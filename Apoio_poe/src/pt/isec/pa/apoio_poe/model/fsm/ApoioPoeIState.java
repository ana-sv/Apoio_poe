package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public interface ApoioPoeIState {


    // interface deve ter poucos metodos 
    // REVER tipo de retorno dos metodos 
/*
    boolean start();

    boolean classificaAlunos();

    boolean continua();

    boolean voltaAtras(); 

    boolean desempate(); 

    boolean end(); 
    */


    ApoioPoeState getState();
}
