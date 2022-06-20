package pt.isec.pa.apoio_poe.model.fsm;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import pt.isec.pa.apoio_poe.model.data.Data;

public final class Ficheiro {

    private Ficheiro() {
    } // para evitar que ser possivel criar uma classe Ficheiro

    public static String gravaParaBinario(Data data, String nomeFicheiro) {

        if (!nomeFicheiroValido(nomeFicheiro))
            return "Nome de ficheiro invalido!";

        try {
            // create a new file with an ObjectOutputStream
            FileOutputStream f = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream out = new ObjectOutputStream(f);

            // write something in the file
            out.writeObject(data);

            // close the stream
            out.close();

            return "Gravado com sucesso !";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return " ";
    }

    public static Data carregaDeBinario(String nomeFicheiro) {

        if (!nomeFicheiroValido(nomeFicheiro))
            return null;

            try {
               
                FileInputStream f = new FileInputStream(nomeFicheiro);
                try (ObjectInputStream in = new ObjectInputStream(f)) {
                    return (Data) in.readObject();
                } 

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;


    }




    public static boolean mailValido(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean nomeFicheiroValido(String filename) {
        String[] f = filename.split("\\.");

        if (f.length > 1)
            return false;

        return true;
    }


    public static String exportaCVS(String nomeFicheiro, String str) {

        StringBuilder sb = new StringBuilder();
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        if (!nomeFicheiroValido(nomeFicheiro)) {
            return sb.append("ATENCAO! Nome do ficheiro nao e' valido! ").toString();
        } else if (!nomeFicheiro.endsWith(".csv"))
            nomeFicheiro += ".csv";

        try {
            fw = new FileWriter(nomeFicheiro);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(str);

            pw.close();
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            sb.append("The specified file was not found");
        } catch (IOException e) {
            sb.append("There was an error (IOException)");
        }

        return sb.toString();
    }



    
    public static String importaCVSalunos(String nomeFicheiro, Data data) {
        StringBuilder sb = new StringBuilder();
        long numeroAluno;
        double classificacao;
        boolean estagioAcesso;
        String nome, mail, linha;
        String curso;
        String ramo;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;

        try {
            fr = new FileReader(nomeFicheiro + ".csv");
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                // Numero Aluno
                if (sc.hasNext()) {
                    String snString = sc.next();
                    if (snString.length() != 10) {
                        sb.append("Numero de aluno nao e valido");
                        break;
                    }

                    numeroAluno = Long.parseLong(snString);

                    if (data.alunoExiste(numeroAluno)) {
                        sb.append("Aluno com numero " + numeroAluno + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Numero de aluno nao encontrado");
                    break;
                }

                // Nome
                if (sc.hasNext()) {
                    nome = sc.next();
                } else {
                    sb.append("ATENCAO! Nome nao encontrado");
                    break;
                }

                // Mail
                if (sc.hasNext()) {
                    mail = sc.next();
                    if (!mailValido(mail)) {
                        sb.append("ATENCAO! Mail nao é valido");
                        break;
                    }

                    if (data.alunoExiste(mail)) {
                        sb.append("ATENCAO! Mail  " + mail + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Mail nao encontrado\n");
                    break;
                }

                // Curso
                if (sc.hasNext()) {
                    curso = sc.next();
                    if (!(curso.equalsIgnoreCase("LEI") || curso.equalsIgnoreCase("LEI-PL"))) {
                        sb.append("ATENCAO! Curso não é valido ");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Curso nao encontrado");
                    break;
                }

                // Ramo
                if (sc.hasNext()) {
                    ramo = sc.next();
                    if (!(ramo.equalsIgnoreCase("DA") || ramo.equalsIgnoreCase("RAS") || ramo.equalsIgnoreCase("SI"))) {
                        sb.append("ATENCAO! Ramo nao é valido");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Ramo nao encontrado!\n");
                    break;
                }

                // Classificação
                if (sc.hasNext()) {
                    String cString = sc.next();
                    classificacao = Double.parseDouble(cString);
                    if (classificacao > 1 || classificacao < 0) {
                        sb.append("ATENCAO! Classificacao nao e valida!\n");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Classificacao nao encontrada!\n");
                    break;
                }
                // Acesso Estagio
                if (sc.hasNext()) {
                    String cString = sc.next();
                    estagioAcesso = Boolean.parseBoolean(cString);
                    if (classificacao > 1 || classificacao < 0) {
                        sb.append("Classificacao invalida!\n"); //// ??? rever
                        break;
                    }
                } else {
                    sb.append("Classificacao nao encontrada!\n");
                    break;
                }

                // Adicionar Aluno
                if (!sc.hasNext())
                    data.adicionaAluno(numeroAluno, nome, mail, curso, ramo, classificacao, estagioAcesso);
                else
                    sb.append("Atributos a mais!\n");

            }

            if (sc != null)
                sc.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            sb.append("O ficheiro nao foi encontrado\n");
        } catch (NumberFormatException e) {
            sb.append("Argumento deverá ser um numero\n");
        } catch (IOException e) {
            sb.append("Houve um erro (IOException)\n");
        }

        return sb.toString();
    }

    public static String importaCVSdocentes(String nomeFicheiro, Data data) {
        StringBuilder sb = new StringBuilder();
        String nome, mail, linha;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;

        try {
            fr = new FileReader(nomeFicheiro + ".csv");
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                // Nome
                if (sc.hasNext()) {

                    String snString = sc.next();
                    nome = snString;
                } else {
                    sb.append("ATENCAO! Nome nao encontrado");
                    break;
                }

                // Mail
                if (sc.hasNext()) {

                    mail = sc.next();

                    if (data.docenteExiste(mail)) {
                        sb.append("ATENCAO! Docente com  " + mail + " ja existe\n");
                        break;
                    }
                    if (!mailValido(mail)) {
                        sb.append("ATENCAO! Mail nao é valido");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Mail do docente nao encontrado");
                    break;
                }

                // Adicionar Docente
                if (!sc.hasNext())
                    data.adicionaDocente(nome, mail);
                else
                    sb.append("ATENCAO! Atribuitos a mais \n");

            }

            if (sc != null)
                sc.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            sb.append("O ficheiro nao foi encontrado\n");
        } catch (NumberFormatException e) {
            sb.append("Argumento deverá ser um numero\n");
        } catch (IOException e) {
            sb.append("Houve um erro (IOException)\n");
        }

        return sb.toString();
    }

    private static boolean importEstagio(Scanner sc, Data data) {
        StringBuilder sb = new StringBuilder();
        String codigoProp = null, area = null, entAcolhimento = null, titulo = null;

        // Codigo Proposta
        if (sc.hasNext()) {
            codigoProp = sc.next();
        } else {
            sb.append("Codigo de proposta nao encontrado");
            return false;
        }

        // Area Proposta
        if (sc.hasNext()) {
            area = sc.next();
        } else {
            sb.append("Area de proposta nao encontrado");
            return false;
        }
        // Titulo Proposta
        if (sc.hasNext()) {
            titulo = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }
        // Entidade de Acolhimento Proposta
        if (sc.hasNext()) {
            entAcolhimento = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }

        // Adicionar Proposta
        if (!sc.hasNext())
            data.adicionaEstagio(codigoProp, area, titulo, entAcolhimento);
        else
            sb.append("Atributos a mais!\n");

        return true;
    }

    private static boolean importAutoProposta(Scanner sc, Data data) {
        StringBuilder sb = new StringBuilder();
        String codigoProp = null, titulo = null;
        long numeroAluno = 0;

        // Codigo Proposta
        if (sc.hasNext()) {
            codigoProp = sc.next();
        } else {
            sb.append("Codigo de proposta nao encontrado");
            return false;
        }
        // Titulo Proposta
        if (sc.hasNext()) {
            titulo = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }
        // Numero Aluno Proposta
        if (sc.hasNext()) {
            String snString = sc.next();
            ;
            if (snString.length() != 10) {
                sb.append("Numero de aluno nao e valido");

            }
            numeroAluno = Long.parseLong(snString);
        } else {
            sb.append("Numero Aluno proposta nao encontrado");
            return false;
        }

        // Adicionar Proposta
        if (!sc.hasNext())
            data.adicionaAutoProposta(codigoProp, titulo, numeroAluno);
        else
            sb.append("Atributos a mais!\n");

        return true;
    }

    private static boolean importProjecto(Scanner sc, Data data) {
        StringBuilder sb = new StringBuilder();
        String codigoProp = null, mail = null, area = null, titulo = null;
        long numeroAluno = 0;

        // Codigo Proposta
        if (sc.hasNext()) {
            codigoProp = sc.next();
        } else {
            sb.append("Codigo de proposta nao encontrado");
            return false;
        }

        // Area Proposta
        if (sc.hasNext()) {
            area = sc.next();
        } else {
            sb.append("Area de proposta nao encontrado");
            return false;
        }
        // Titulo Proposta
        if (sc.hasNext()) {
            titulo = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }
        // Entidade de Acolhimento Proposta
        if (sc.hasNext()) {
            mail = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }
        // Numero Aluno Proposta
        if (sc.hasNext()) {
            String snString = sc.next();
            if (snString.length() != 10) {
                sb.append("Numero de aluno nao e valido");

            }
            numeroAluno = Long.parseLong(snString);
        } else {
            sb.append("Numero Aluno proposta nao encontrado");
            return false;
        }

        // Adicionar Proposta
        if (!sc.hasNext())
            data.adicionaProjecto(codigoProp, area, titulo, mail, numeroAluno);
        else
            sb.append("Atributos a mais!\n");

        return true;
    }

    public static String importaCVSpropostas(String nomeFicheiro, Data data) {
        StringBuilder sb = new StringBuilder();
        String tipoProp = null;
        String linha;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;

        try {
            fr = new FileReader(nomeFicheiro + ".csv");
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                // Tipo Proposta
                if (sc.hasNext()) {
                    String snString = sc.next();
                    tipoProp = snString;

                    if (tipoProp.equals("T1")) {
                        importEstagio(sc, data);
                    }
                    if (tipoProp.equals("T2")) {
                        importProjecto(sc, data);
                    }
                    if (tipoProp.equals("T3")) {
                        importAutoProposta(sc, data);
                    }

                } else {
                    sb.append("codigoProp da proposta nao encontrado");
                    break;
                }
            }

            if (sc != null)
                sc.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            sb.append("O ficheiro nao foi encontrado\n");
        } catch (NumberFormatException e) {
            sb.append("Argumento deverá ser um numero\n");
        } catch (IOException e) {
            sb.append("Houve um erro (IOException)\n");
        }

        return sb.toString();

    }

    public static String importaCVScandidaturas(String nomeFicheiro, Data data) {

        StringBuilder sb = new StringBuilder();
        long numeroAluno;
        String linha;

        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;

        try {
            fr = new FileReader(nomeFicheiro + ".csv");
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                ArrayList<String> codigoPropostas = new ArrayList<>();
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                // Numero Aluno
                if (sc.hasNext()) {
                    String snString = sc.next();
                    if (snString.length() != 10) {
                        sb.append("Numero de aluno nao e valido");
                        break;
                    }

                    numeroAluno = Long.parseLong(snString);

                    if (data.alunoExiste(numeroAluno)) {
                        sb.append("Aluno com numero " + numeroAluno + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Numero de aluno nao encontrado");
                    break;
                }

                // codigo prop
                while (sc.hasNext()) {
                    codigoPropostas.add(sc.next());
                }

                // Adicionar Aluno
                if (!sc.hasNext())
                    data.adicionaCandidatura(numeroAluno, codigoPropostas);
                else
                    sb.append("Atributos a mais!\n");

            }

            if (sc != null)
                sc.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            sb.append("O ficheiro nao foi encontrado\n");
        } catch (NumberFormatException e) {
            sb.append("Argumento deverá ser um numero\n");
        } catch (IOException e) {
            sb.append("Houve um erro (IOException)\n");
        }

        return sb.toString();
    }
}
