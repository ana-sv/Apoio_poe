package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

 class ResolveEmpates extends StateAdapter{

    ResolveEmpates(Context context, Data data) {
        super(context, data);
    }



    //TO DO 
    // desempate() 

    @Override
    public State getState() {
        return State.RESOLVE_EMPATES;
    }

    @Override
    public void avancaEstado() {
        // TODO if nEmpates==0
        changeState(State.ATRIBUICAO_PROPOSTAS);
        //else
        // desempate()  ???? 

    }



    



    
    
}
