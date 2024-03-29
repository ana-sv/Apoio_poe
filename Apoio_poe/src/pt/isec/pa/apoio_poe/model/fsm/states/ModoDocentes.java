package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;

class ModoDocentes extends StateAdapter {

     ModoDocentes(ApoioPoeContext context, Data data) {
        super(context, data);
    }


    @Override
    public String importaCVS(String nomeFicheiro) {
        return Ficheiro.importaCVSdocentes(nomeFicheiro, this.data);
    }


    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.MODO_DOCENTES;
    }


    @Override
    public void avancaEstado() {
        changeState(ApoioPoeState.OPCOES_CANDIDATURAS);
    }



    @Override
    public boolean voltar() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
        return true;
    }



    
}
