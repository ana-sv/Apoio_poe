package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class ModoAlunos extends ApoioPoeStateAdapter{

    ModoAlunos(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }



    @Override
    public String exportaCVS() {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String filtrarListas() {
        // TO DO
        return " nao implementado ainda";
    }

    @Override
    public String importaCVS(String nomeFicheiro) {
        
        return " nao implementado ainda";
    }

    

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.MODO_ALUNOS;
    }


    @Override
    public void avanca() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }



    
}
