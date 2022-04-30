package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class ResolveEmpates extends ApoioPoeStateAdapter{

    ResolveEmpates(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }



    //TO DO 
    // desempate() 

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.RESOLVE_EMPATES;
    }

    @Override
    public void avanca() {
        // TODO if nEmpates==0
        changeState(ApoioPoeState.ATRIBUICAO_PROPOSTAS);
        //else
        // desempate()  ???? 

    }





    
    
}
