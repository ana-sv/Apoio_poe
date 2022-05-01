package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class ModoDocentes extends ApoioPoeStateAdapter {

     ModoDocentes(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }


    @Override
    public String exportaCVS() {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String filtrarListas() {
        return data.getListaDocentes().toString();
    }

    @Override
    public String importaCVS(String nomeFicheiro) {
        StringBuilder sb = new StringBuilder();
        String nome, mail, linha;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;

        try{
            fr = new FileReader(nomeFicheiro);
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                //Mail Docente
                if (sc.hasNext()) {
                    String snString = sc.next();
                    mail = snString;

                    if (data.docenteExiste(mail)) {
                        sb.append("Docente com  " + mail + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("Mail do docente nao encontrado");
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

                    if (data.docenteExiste(mail)) {
                        sb.append("Mail  " + mail + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("Mail nao encontrado\n");
                    break;
                }


                //Adicionar Docente
                if(!sc.hasNext())
                    data.adicionaDocente(nome, mail);
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
        return ApoioPoeState.MODO_DOCENTES;
    }


    @Override
    public void avanca() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }




    
}
