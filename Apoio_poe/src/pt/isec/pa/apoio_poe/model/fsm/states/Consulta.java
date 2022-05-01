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



    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.CONSULTA;
    }


    @Override
    public String mostraListas() {
        // TO DO
        return " nao implementado ainda";
    }


    @Override
    public String exportaCVS(String nomeFicheiro) {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String filtraListas() {
        // TO DO
        return " nao implementado ainda";
    }

 
}
