package pt.isec.pa.apoio_poe.model.fsm.states;

import java.io.*;
import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

class AtribuicaoPropostas extends ApoioPoeStateAdapter{
    Fase fase;

 AtribuicaoPropostas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;
    }

    public boolean atribuicaoAuto(){
         // se fase aberta --> atribui automaticamente 
                // se existem empates   changeState(ApoioPoeState.RESOLVE_EMPATES);
                // se nao exitem    continua no mesmo estado
                
            return false; 

    }

    @Override
    public String filtraListasAlunos( String filtros ) {
        // TO DO
        return " nao implementado ainda";
    }

    @Override
    public String filtraListasPropostas( String filtros ) {
        // TO DO
        return " nao implementado ainda";
    }


    @Override
    public String mostraListas() {
        StringBuilder s = new StringBuilder();

        s.append(data.infoCandidaturasToString(false));

    return s.toString();
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
    public ApoioPoeState getState() {
        return ApoioPoeState.ATRIBUICAO_PROPOSTAS;
    }

    @Override
    public void avanca() {
        changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
    }

    @Override
    public boolean fechaFase() {
        //TODO 
        // if(nCandidaturas=nPropostas ){
         //   fase = Fase.FECHADA;
      //    changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
      //      return true;   }

        return false;
    }

    @Override
    public boolean voltar() {
        if( fase == Fase.ABERTA ){
            changeState(ApoioPoeState.ORGANIZA_CANDIDATURAS);
            return true;
        }
        return false; 

    }




    
}
