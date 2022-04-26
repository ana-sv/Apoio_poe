
/**
*
*  @author AnaVideira 
*
*  Classe que comunica com a user interface
*
*/


package pt.isec.pa.apoio_poe.model.fsm;

public class ApoioPoeContext {
    ApoioPoeIState state; 






    // getters

    public ApoioPoeState getState(){
        if( state == null )
            return null;
            
        return state.getState(); 
    }




    
}
