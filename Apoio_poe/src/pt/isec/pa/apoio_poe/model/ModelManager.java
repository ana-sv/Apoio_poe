package pt.isec.pa.apoio_poe.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public class ModelManager {

    private ApoioPoeContext fsm;
    protected PropertyChangeSupport pcs;

    public ModelManager() {
        fsm = new ApoioPoeContext();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    
    public void avancaEstado() {
        fsm.avancaEstado();
        pcs.firePropertyChange(null, null, null);
    }

    public void avancaParaAlunos(){
        fsm.avancaParaAlunos();
        pcs.firePropertyChange(null, null, null);
    }
    public void avancaParaDocentes(){
        fsm.avancaParaDocentes();
        pcs.firePropertyChange(null, null, null);
    }
    public void avancaParaPropostas(){
        fsm.avancaParaPropostas();
        pcs.firePropertyChange(null, null, null);
    }





    public void carregaEstadoAplicacao(String caminhoFicheiro) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(caminhoFicheiro));
        fsm = (ApoioPoeContext) oin.readObject();
        oin.close();

    }

    public ApoioPoeState getState() {
        return fsm.getState();
    }




}
