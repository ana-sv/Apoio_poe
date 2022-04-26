package pt.isec.pa.apoio_poe.model.fsm;

public interface ApoioPoeIState {

    void start();
    void end();


    ApoioPoeState getState(); 
}
