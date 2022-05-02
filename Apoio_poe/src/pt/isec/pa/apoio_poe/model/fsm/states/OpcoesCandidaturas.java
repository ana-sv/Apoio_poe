package pt.isec.pa.apoio_poe.model.fsm.states;
import java.io.*;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class OpcoesCandidaturas extends ApoioPoeStateAdapter {
    Fase fase;

     OpcoesCandidaturas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;
    }


    @Override
    public String filtraListasAlunos( Integer q , String filtros ) {  //autoproposta , registada , nao registada


        // TO DO
        return " nao implementado ainda";
    }



    @Override
    public String filtraListasPropostas( Integer q ,String filtros ) { // autopropostas, docentes, com candidatura , sem candidatura
        // TO DO
        return " nao implementado ainda";
    }

    @Override
    public String mostraListas() {
        StringBuilder s = new StringBuilder();

        for( Candidatura c : data.getListaCandidaturas().values() )
            s.append( c.candidaturaToString() );

        return s.toString();
    }


    @Override
    public String importaCVS(String nomeFicheiro) {

        // TO DO 
        return " nao implementado ainda";
    }




    public boolean nomeFicheiroValido(String filename) {
        String[] f = filename.split("\\.");

        if(f.length > 1)
            return false;

        return true;
    }

    @Override
    public String exportaCVS(String nomeFicheiro) {
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
    public ApoioPoeState getState() {
        return ApoioPoeState.ORGANIZA_CANDIDATURAS;
    }



    @Override
    public boolean voltar(){ 
        if ( fase == Fase.ABERTA ){
            changeState( ApoioPoeState.AGUARDA_CONFIGURACAO );
            return true;
        }
        return false; 
    }


    @Override
    public void avanca() {
        changeState( ApoioPoeState.ATRIBUICAO_PROPOSTAS );
  
    }

    @Override
    public boolean fechaFase() {
        // TODO : impedir fechar se houverem candidaturas sem proposta 

        fase = Fase.FECHADA;
        return true;    
    }








    
    
}
