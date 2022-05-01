package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.data.Proposta.TipoProposta;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class ModoPropostas extends ApoioPoeStateAdapter{

     ModoPropostas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }

    
    @Override
    public String exportaCVS() {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String mostraListas() {
        return data.getListaProposta().toString();
    }

    @Override
    public String importaCVS(String nomeFicheiro) {
        StringBuilder sb = new StringBuilder();
        TipoProposta tipoProp = null;
        String codigoProp, titulo, linha;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;

        try{
            fr = new FileReader(nomeFicheiro);
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                //Codigo Proposta
                if (sc.hasNext()) {
                    String snString = sc.next();
                    codigoProp = snString;

                    if (data.propostaExiste(codigoProp)) {
                        sb.append("Proposta com  " + codigoProp + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("codigoProp da proposta nao encontrado");
                    break;
                }

                //Titulo
                if (sc.hasNext()) {
                    titulo = sc.next();
                } else {
                    sb.append("Titulo nao encontrado");
                    break;
                }
                //Adicionar Proposta
                if(!sc.hasNext())
                    data.adicionaProposta(tipoProp, codigoProp, titulo);
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
        return ApoioPoeState.MODO_PROPOSTAS;
    }

    @Override
    public void avanca() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }
    



}
