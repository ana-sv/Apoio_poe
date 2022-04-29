package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeState;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

public class AtribuicaoOrientadores extends ApoioPoeStateAdapter {

    protected AtribuicaoOrientadores(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.ATRIBUICAO_ORIENTADORES;
    }


    
}
