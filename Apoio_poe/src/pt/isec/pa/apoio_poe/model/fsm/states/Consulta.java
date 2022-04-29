package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class Consulta extends ApoioPoeStateAdapter {
     boolean fase;

     Consulta(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = true;
    }

    // TO DO 
    // exportarInformacao 

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.CONSULTA;
    }

    @Override
    public String filtrarListas() {
        // TODO 
        return super.filtrarListas();
    }
    
}
