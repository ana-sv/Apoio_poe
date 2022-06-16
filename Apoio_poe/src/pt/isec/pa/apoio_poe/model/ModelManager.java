package pt.isec.pa.apoio_poe.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;


public class ModelManager {

    private ApoioPoeContext fsm;
    protected PropertyChangeSupport pcs;

    public ModelManager(){
        fsm = new ApoioPoeContext();
        pcs = new PropertyChangeSupport(this); 
    }
    

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }



    public ApoioPoeState getState(){
        return fsm.getState();
    }



    
}
