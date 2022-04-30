package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.data.Enum;
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
        // TO DO
        return " nao implementado ainda";
    }

    @Override
    public String importaCVS(String nomeFicheiro) {
        StringBuilder sb = new StringBuilder();
        long numeroAluno;
        double classificacao;
        boolean internshipAccess;
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

                //Student Number
                if (sc.hasNext()) {
                    String snString = sc.next();
                    if(snString.length()!=10){
                        sb.append("Student Number is not valid");
                        break;
                    }

                    numeroAluno = Long.parseLong(snString);

                    if (data.alunoExiste(numeroAluno)) {
                        sb.append("Student with number " + numeroAluno + " already exists\n");
                        break;
                    }
                } else {
                    sb.append("Student Number not found");
                    break;
                }

                //Name
                if (sc.hasNext()) {
                    nome = sc.next();
                } else {
                    sb.append("Name not found");
                    break;
                }

                //Email
                if (sc.hasNext()) {
                    mail = sc.next();
                    if(!context.emailIsValid(mail)) {
                        sb.append("Email is not valid");
                        break;
                    }

                    if (data.alunoExiste(mail)) {
                        sb.append("Student with email " + mail + " already exists\n");
                        break;
                    }
                } else {
                    sb.append("Email not found\n");
                    break;
                }

                //Course
                if (sc.hasNext()) {
                    curso = sc.next();
                    if(!(curso.equalsIgnoreCase("LEI") || curso.equalsIgnoreCase("LEI-PL"))){
                        sb.append("Course is not valid");
                        break;
                    }
                } else {
                    sb.append("Course not found");
                    break;
                }

                //Branch
                if (sc.hasNext()) {
                    ramo = sc.next();
                    if(!(ramo.equalsIgnoreCase("DA") || ramo.equalsIgnoreCase("RAS") || ramo.equalsIgnoreCase("SI"))){
                        sb.append("Branch is not valid");
                        break;
                    }
                } else {
                    sb.append("Branch not found");
                    break;
                }

                //Classification
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

                //Internship Access
                if (sc.hasNext()) {
                    String iaString = sc.next();
                    if(!(iaString.equalsIgnoreCase("TRUE") || iaString.equalsIgnoreCase("FALSE"))){
                        sb.append("Internship Access Value is not valid");
                        break;
                    }
                    internshipAccess = Boolean.parseBoolean(iaString);
                } else {
                    sb.append("Student Number not found");
                    break;
                }

                //Add Student
                if(!sc.hasNext())
                    data.adicionaAluno(numeroAluno, nome, mail, curso, ramo);
                else
                    sb.append("More fields than expected\n");

            }

            if(sc!=null) sc.close();
            br.close();
            fr.close();
        }catch (FileNotFoundException e){
            sb.append("The specified file was not found\n");
        }catch (NumberFormatException e){
            sb.append("Argument should be a number but it was not\n");
        }catch (IOException e){
            sb.append("There was an error (IOException)\n");
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
