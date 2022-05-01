package pt.isec.pa.apoio_poe.model.fsm.states;

import java.io.*;
import java.util.*;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

/*

NOTAS DE IMPLEMENTAÇAO 

Default: When no access modifier is specified for a class, method, or data member 
– It is said to be having the default access modifier by default. 

The data members, class or methods which are not declared using any
access modifiers i.e. having default access modifier are accessible only within the same package.


*/

class AguardaConfiguracao extends ApoioPoeStateAdapter {
    Fase fase;

    AguardaConfiguracao(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;

    }

    @Override
    public String mostraListas() {

        StringBuilder s = new StringBuilder();

            s.append("> Lista Alunos ");
            s.append(data.getListaAlunos());

            s.append("> Lista Docentes ");
            s.append(data.getListaDocentes());

            s.append("> Lista Propostas ");
            s.append(data.getListaProposta());

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
    public String filtraListas() {
        // TO DO
        return " nao implementado ainda";
    }

    public void classificaAlunos() {
        // TO DO - META 2
    }

    @Override
    public void avanca() { // avanca sem fechar fase

        // classificaAlunos()
        changeState(ApoioPoeState.ORGANIZA_CANDIDATURAS);
    }

    @Override
    public boolean fechaFase() { // avança e fecha fase

        // classificaAlunos()

        if (data.contaPropostasDA() >= data.getListaAlunos().size()
                && data.contaPropostasSI() >= data.getListaAlunos().size()
                && data.contaPropostasRAS() >= data.getListaAlunos().size()) { 
            fase = Fase.FECHADA;
            return true;
        }

        return false;
    }

    @Override
    public boolean alteraModoConfiguracao(int op) {
        switch (op) {
            case 1 -> changeState(ApoioPoeState.MODO_ALUNOS);
            case 2 -> changeState(ApoioPoeState.MODO_DOCENTES);
            case 3 -> changeState(ApoioPoeState.MODO_PROPOSTAS);
            default -> {
                return false;
            }
        }
        return false;
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.AGUARDA_CONFIGURACAO;
    }

    public Fase getFase() {
        return fase;
    }

}
