package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.data.Proposta.TipoProposta;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

import java.io.*;
import java.util.*;

class ModoPropostas extends ApoioPoeStateAdapter{

     ModoPropostas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }

    
    public boolean nomeFicheiroValido(String filename) {
        String[] f = filename.split("\\.");

        if(f.length > 1)
            return false;

        return true;
    }


    @Override
    public String exportaCVS( String nomeFicheiro ) {
        
        StringBuilder sb = new StringBuilder();
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        if(!nomeFicheiroValido(nomeFicheiro)){
            return sb.append("ATENCAO! Nome do ficheiro nao e' valido! ").toString();
        }else if(!nomeFicheiro.endsWith(".csv"))
        nomeFicheiro  += ".csv";

        try{
            fw = new FileWriter(nomeFicheiro );
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);


            pw.println(mostraListas());

            pw.close();
            bw.close();
            fw.close();
        }catch (FileNotFoundException e){
            sb.append("The specified file was not found");
        }catch (IOException e){
            sb.append("There was an error (IOException)");
        }

        return sb.toString();
    }

    @Override
    public String mostraListas() {
        StringBuilder str= new StringBuilder();
        for ( Proposta a : data.getListaProposta().values()) {
            str.append(a.propostasToString());
        }

        
        if(str.isEmpty())
            str.append("\n> SEM IMFORMACAO !");

        return str.toString();
    }
    private boolean importEstagio(Scanner sc){
        StringBuilder sb = new StringBuilder();
        String codigoProp = null, area = null, entAcolhimento = null, titulo=null;


                //Codigo Proposta
                if (sc.hasNext()) {
                    codigoProp = sc.next();
                } else {
                    sb.append("Codigo de proposta nao encontrado");
                    return false;
                }

                //Area Proposta
                if (sc.hasNext()) {
                    area = sc.next();
                } else {
                    sb.append("Area de proposta nao encontrado");
                    return false;
                }
                //Titulo Proposta
                if (sc.hasNext()) {
                    titulo = sc.next();
                } else {
                    sb.append("Titulo de proposta nao encontrado");
                    return false;
                }
                //Entidade de Acolhimento Proposta
                if (sc.hasNext()) {
                    entAcolhimento = sc.next();
                } else {
                    sb.append("Titulo de proposta nao encontrado");
                    return false;
                }

                //Adicionar Proposta
                if(!sc.hasNext())
                    data.adicionaEstagio(codigoProp, area, titulo, entAcolhimento);
                else
                    sb.append("Atributos a mais!\n");

        return true;
    }
    private boolean importAutoProposta(Scanner sc){
        StringBuilder sb = new StringBuilder();
        String codigoProp = null, titulo=null;
        long numeroAluno = 0;

        //Codigo Proposta
        if (sc.hasNext()) {
            codigoProp = sc.next();
        } else {
            sb.append("Codigo de proposta nao encontrado");
            return false;
        }
        //Titulo Proposta
        if (sc.hasNext()) {
            titulo = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }
        //Numero Aluno Proposta
        if (sc.hasNext()) {
            String snString = sc.next();;
            if (snString.length() != 10) {
                sb.append("Numero de aluno nao e valido");

            }
            numeroAluno = Long.parseLong(snString);
        }else {
            sb.append("Numero Aluno proposta nao encontrado");
            return false;
        }

        //Adicionar Proposta
        if(!sc.hasNext())
            data.adicionaAutoProposta(codigoProp, titulo, numeroAluno);
        else
            sb.append("Atributos a mais!\n");

        return true;
    }
    private boolean importProjecto(Scanner sc){
        StringBuilder sb = new StringBuilder();
        String codigoProp = null,mail=null, area = null, titulo=null;
        long numeroAluno = 0;

        //Codigo Proposta
        if (sc.hasNext()) {
            codigoProp = sc.next();
        } else {
            sb.append("Codigo de proposta nao encontrado");
            return false;
        }

        //Area Proposta
        if (sc.hasNext()) {
            area = sc.next();
        } else {
            sb.append("Area de proposta nao encontrado");
            return false;
        }
        //Titulo Proposta
        if (sc.hasNext()) {
            titulo = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }
        //Entidade de Acolhimento Proposta
        if (sc.hasNext()) {
            mail = sc.next();
        } else {
            sb.append("Titulo de proposta nao encontrado");
            return false;
        }
        //Numero Aluno Proposta
        if (sc.hasNext()) {
            String snString = sc.next();
            if (snString.length() != 10) {
                sb.append("Numero de aluno nao e valido");

            }
            numeroAluno = Long.parseLong(snString);
        }else {
            sb.append("Numero Aluno proposta nao encontrado");
            return false;
        }

        //Adicionar Proposta
        if(!sc.hasNext())
            data.adicionaProjecto(codigoProp, area, titulo, mail, numeroAluno);
        else
            sb.append("Atributos a mais!\n");

        return true;
    }
    @Override
    public String importaCVS(String nomeFicheiro) {
        StringBuilder sb = new StringBuilder();
        TipoProposta tipoProp = null;
        String linha;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;


        try{
            fr = new FileReader(nomeFicheiro+".csv");
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                sc = new Scanner(linha);
                sc.useDelimiter(",");



                //Tipo Proposta
                if (sc.hasNext()) {
                    String snString = sc.next();
                    tipoProp = TipoProposta.valueOf(snString);

                    if(tipoProp.name().equals("T1")){
                        importEstagio(sc);
                    }
                    if(tipoProp.name().equals("T2")){
                        importProjecto(sc);
                    }
                    if(tipoProp.name().equals("T3")){
                        importAutoProposta(sc);
                    }

                } else {
                    sb.append("codigoProp da proposta nao encontrado");
                    break;
                }
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
