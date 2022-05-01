package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;



public abstract class ApoioPoeStateAdapter implements ApoioPoeIState{
    protected ApoioPoeContext context;
    protected ApoioPoeData data; 


    protected ApoioPoeStateAdapter(ApoioPoeContext context, ApoioPoeData data) {
        this.context = context;
        this.data = data; 
    }


    protected void changeState( ApoioPoeState newState ){
        context.changeState(newState.createState(context,data));
    }
    

    @Override
    public String mostraListas() {
        return " ";
    }

    @Override
    public String filtraListas() {
        return " ";
    }

    @Override
    public String exportaCVS() {
        return " ";
    }
    

    @Override
    public String importaCVS( String nomeFicheiro ){
        return " ";
    }


    @Override
    public boolean alteraModoConfiguracao(int op) {
        return false;
    }
    @Override
    public boolean voltar() {
        return false;
    }

    @Override
    public void avanca() {  }

    @Override
    public boolean fechaFase(){  
        return false; 
      }


    @Override
    public ApoioPoeState getState() {
        return null;
    }


    @Override
    public Fase getFase() {
        return null;
    }





}
