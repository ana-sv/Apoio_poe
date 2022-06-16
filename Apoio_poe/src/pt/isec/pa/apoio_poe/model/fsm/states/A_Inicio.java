package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class A_Inicio extends StateAdapter{

    protected A_Inicio(ApoioPoeContext context, Data data) {
        super(context, data); }
    

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.INICIO;
    }


    @Override
    public void avancaEstado() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }

    

    
}
