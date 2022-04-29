package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;



public abstract class ApoioPoeStateAdapter implements ApoioPoeIState{
    ApoioPoeContext context;
    ApoioPoeData data; 

    protected ApoioPoeStateAdapter(ApoioPoeContext context, ApoioPoeData data) {
        this.context = context;
        this.data = data; 
    }


    protected void changeState( ApoioPoeState newState ){
        context.changeState(newState.createState(context,data));
    }


    @Override
    public String filtrarListas() {
        // TODO 
        return null;
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







}
