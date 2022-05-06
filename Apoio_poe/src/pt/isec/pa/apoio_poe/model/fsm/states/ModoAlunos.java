package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.data.Ficheiro;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class ModoAlunos extends ApoioPoeStateAdapter{

    ModoAlunos(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }


    @Override
    public String mostraListas() {
        StringBuilder str= new StringBuilder();
        for ( Aluno a : data.getListaAlunos().values()) {
            str.append(a.alunoToString());
        }

        if(str.isEmpty())
            str.append("\n> SEM IMFORMACAO !");

        return str.toString();
    }



    public boolean mailValido(String email) {            
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    
    
    @Override
    public String importaCVS(String nomeFicheiro) {
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

        try{
            fr = new FileReader(nomeFicheiro+".csv");
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                //Numero Aluno
                if (sc.hasNext()) {
                    String snString = sc.next();
                    if(snString.length()!=10){
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

                //Nome
                if (sc.hasNext()) {
                    nome = sc.next();
                } else {
                    sb.append("ATENCAO! Nome nao encontrado");
                    break;
                }

                //Mail
                if (sc.hasNext()) {
                    mail = sc.next();
                    if(!mailValido(mail)) {
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

                //Curso
                if (sc.hasNext()) {
                    curso = sc.next();
                    if(!(curso.equalsIgnoreCase("LEI") || curso.equalsIgnoreCase("LEI-PL"))){
                        sb.append("ATENCAO! Curso não é valido ");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Curso nao encontrado");
                    break;
                }

                //Ramo
                if (sc.hasNext()) {
                    ramo = sc.next();
                    if(!(ramo.equalsIgnoreCase("DA") || ramo.equalsIgnoreCase("RAS") || ramo.equalsIgnoreCase("SI"))){
                        sb.append("ATENCAO! Ramo nao é valido");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Ramo nao encontrado!\n");
                    break;
                }

                //Classificação
                if (sc.hasNext()) {
                    String cString = sc.next();
                    classificacao = Double.parseDouble(cString);
                    if(classificacao>1 || classificacao<0){
                        sb.append("ATENCAO! Classificacao nao e valida!\n");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Classificacao nao encontrada!\n");
                    break;
                }
                //Acesso Estagio
                if (sc.hasNext()) {
                    String cString = sc.next();
                    estagioAcesso = Boolean.parseBoolean(cString);
                    if(classificacao>1 || classificacao<0){
                        sb.append("Classificacao invalida!\n");       ////???  rever 
                        break;
                    }
                } else {
                    sb.append("Classificacao nao encontrada!\n");
                    break;
                }


                //Adicionar Aluno
                if(!sc.hasNext())
                    data.adicionaAluno(numeroAluno, nome, mail, curso, ramo, classificacao, estagioAcesso);
                else
                    sb.append("Atributos a mais!\n");

            }

            if(sc!=null) sc.close();
            br.close();
            fr.close();
        }catch (FileNotFoundException e){
            sb.append("O ficheiro nao foi encontrado\n");
        }catch (NumberFormatException e){
            sb.append("Argumento deverá ser um numero\n");
        }catch (IOException e){
            sb.append("Houve um erro (IOException)\n");
        }

        return sb.toString();
    }

    

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.MODO_ALUNOS;
    }


    @Override
    public void avanca() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }



    
}
