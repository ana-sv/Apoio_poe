package pt.isec.pa.apoio_poe.ui.gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.data.Proposta;
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


    public ApoioPoeState getState() {
        return fsm.getState();
    }

    public Boolean getSituacaoEstado(){
        return fsm.getSituacaoEstado();
    }
    
    public void avancaEstado() {
        fsm.avancaEstado();
        pcs.firePropertyChange(null, null, null);
    }

       public boolean volta(){
        boolean aux = fsm.volta();
         pcs.firePropertyChange(null, null, null);
         return aux;

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

    public boolean fechaFase(){
       return fsm.fechaFase();
    }

    public String importaCVS(String nomeFicheiro ){
        return fsm.importaCVS(nomeFicheiro);
    }

    public String exportaCVS(String nomeFicheiro, String lista){
        return fsm.exportaCVS(nomeFicheiro, lista);
    }

    public String listaAlunos(){
        return fsm.mostraListaAlunos(); 
    }

    public String listaDocentes(){
        return fsm.mostraListaDocentes(); 
    }

    public String listaPropostas(){
        return fsm.mostraListaPropostas(); 
    }

    public String listaCandidaturas(){
        return fsm.mostraListaCandidaturas();
    }

    public HashMap<Long,Aluno> getListaAlunos(){
        return fsm.getListaAlunos();
    }

    public ArrayList<Aluno> getArrayAlunos(){
        return fsm.getArrayAlunos();
        
    }

    public ArrayList<Docente> getArrayDocentes(){
        return fsm.getArrayDocentes(); 
    }

    public ArrayList<Proposta> getArrayPropostas(){
        return fsm.getArrayPropostas(); 
    }

    public ArrayList<Candidatura> getArrayCandidaturas(){
        return fsm.getArrayCandidaturas();
    }



}
