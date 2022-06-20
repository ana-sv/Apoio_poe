package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

 class ResolveEmpates extends StateAdapter{

    ResolveEmpates(ApoioPoeContext context, Data data) {
        super(context, data);
    }



    //TO DO 
    // desempate() 

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.RESOLVE_EMPATES;
    }

    @Override
    public void avancaEstado() {
        // TODO if nEmpates==0
        changeState(ApoioPoeState.ATRIBUICAO_PROPOSTAS);
        //else
        // desempate()  ???? 

    }



    



    
    
}
