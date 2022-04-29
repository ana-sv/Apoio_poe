package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;

// talvez nao devesse ser public aqui 

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







}
