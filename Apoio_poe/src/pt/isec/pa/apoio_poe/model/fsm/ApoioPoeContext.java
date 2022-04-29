
/**
*
*  @author AnaVideira 
*
*  Classe que comunica com a user interface
*
*/


package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;

public class ApoioPoeContext {
    ApoioPoeIState state; 
    ApoioPoeData data; 

    public ApoioPoeContext(){
        data = new ApoioPoeData();
        state = ApoioPoeState.AGUARDA_CONFIGURACAO.createState(this, data);
    }

    void changeState( ApoioPoeIState newState ){
        state = newState; 
    }





    // getters

    public ApoioPoeState getState(){
        if( state == null )
            return null;
            
        return state.getState(); 
    }




    
}
