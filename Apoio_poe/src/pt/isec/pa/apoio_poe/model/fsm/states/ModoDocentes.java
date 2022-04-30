package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class ModoDocentes extends ApoioPoeStateAdapter {

     ModoDocentes(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.MODO_DOCENTES;
    }


    @Override
    public String filtrarListas() {
        // TODO
        return super.filtrarListas();
    }

    @Override
    public void avanca() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }

    
    @Override
    public String importaCVS(String nomeFicheiro) {
        // TODO Auto-generated method stub
        return super.importaCVS(nomeFicheiro);
    }




    
}
