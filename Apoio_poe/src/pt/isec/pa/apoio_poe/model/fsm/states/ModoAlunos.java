package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class ModoAlunos extends ApoioPoeStateAdapter{

    ModoAlunos(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }



    @Override
    public String exportaCVS() {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String filtrarListas() {
        return data.getListaAlunos().toString();
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
            fr = new FileReader(nomeFicheiro);
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
                    sb.append("Numero de aluno nao encontrado");
                    break;
                }

                //Nome
                if (sc.hasNext()) {
                    nome = sc.next();
                } else {
                    sb.append("Nome nao encontrado");
                    break;
                }

                //Mail
                if (sc.hasNext()) {
                    mail = sc.next();
                    if(!context.mailValido(mail)) {
                        sb.append("Mail nao é valido");
                        break;
                    }

                    if (data.alunoExiste(mail)) {
                        sb.append("Mail  " + mail + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("Mail nao encontrado\n");
                    break;
                }

                //Curso
                if (sc.hasNext()) {
                    curso = sc.next();
                    if(!(curso.equalsIgnoreCase("LEI") || curso.equalsIgnoreCase("LEI-PL"))){
                        sb.append("Curso não é valido ");
                        break;
                    }
                } else {
                    sb.append("Curso nao encontrado");
                    break;
                }

                //Ramo
                if (sc.hasNext()) {
                    ramo = sc.next();
                    if(!(ramo.equalsIgnoreCase("DA") || ramo.equalsIgnoreCase("RAS") || ramo.equalsIgnoreCase("SI"))){
                        sb.append("Ramo nao é valido");
                        break;
                    }
                } else {
                    sb.append("Ramo nao encontrado");
                    break;
                }

                //Classificação
                if (sc.hasNext()) {
                    String cString = sc.next();
                    classificacao = Double.parseDouble(cString);
                    if(classificacao>1 || classificacao<0){
                        sb.append("Classification is not valid");
                        break;
                    }
                } else {
                    sb.append("Student Number not found");
                    break;
                }
                //Acesso Estagio
                if (sc.hasNext()) {
                    String cString = sc.next();
                    estagioAcesso = Boolean.parseBoolean(cString);
                    if(classificacao>1 || classificacao<0){
                        sb.append("Classification is not valid");
                        break;
                    }
                } else {
                    sb.append("Student Number not found");
                    break;
                }


                //Adicionar Aluno
                if(!sc.hasNext())
                    data.adicionaAluno(numeroAluno, nome, mail, curso, ramo, classificacao, estagioAcesso);
                else
                    sb.append("More fields than expected\n");

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
