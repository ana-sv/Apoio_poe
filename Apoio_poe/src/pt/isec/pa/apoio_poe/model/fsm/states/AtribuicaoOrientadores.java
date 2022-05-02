package pt.isec.pa.apoio_poe.model.fsm.states;

import java.io.*;
import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

class AtribuicaoOrientadores extends ApoioPoeStateAdapter {
    Fase fase;

    AtribuicaoOrientadores(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;

    }

    // TO DO
    // Atribuicao automatica se fase=Fase.ABERTA
    // AtualizarOrientadores se fase=Fase.ABERTA



    @Override
    public String filtraListasOrientadores( String filtros ) {
        // TO DO
        return " nao implementado ainda";
    }


    @Override
    public String mostraListas() {
        StringBuilder s = new StringBuilder();

        s.append(data.infoCandidaturasToString(true));

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
        return ApoioPoeState.ATRIBUICAO_ORIENTADORES;
    }

    @Override
    public void avanca() {
        fechaFase();  // porque avançando para o estado Consulta ano é possivel voltar atrás 
        changeState(ApoioPoeState.ORGANIZA_CANDIDATURAS);
    }

    @Override
    public boolean voltar() {
        if (context.getFaseEnum() == Fase.ABERTA) {
            changeState(ApoioPoeState.ATRIBUICAO_PROPOSTAS);
            return true;
        }
        return false;

    }

    @Override
    public boolean fechaFase() {
        // falta certeficar aqui que todos os alunos tem uma candidatura com uma proposta
        fase = Fase.FECHADA;
        return true;
    }

}
