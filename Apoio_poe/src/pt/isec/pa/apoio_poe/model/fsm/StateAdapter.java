package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;



public abstract class StateAdapter implements ApoioPoeIState{
    protected ApoioPoeContext context;
    protected Data data; 


    protected StateAdapter(ApoioPoeContext context, Data data) {
        this.context = context;
        this.data = data; 
    }


    protected void changeState( ApoioPoeState newState ){
        context.changeState(newState.createState(context,data));
    }
    
 
    @Override
    public String exportaCVS( String nomeFicheiro, String lista) {       // está aqui porque todos os estados se servem dela 
        return Ficheiro.exportaCVS(nomeFicheiro, lista);  //exporta de acordo com as informações de cada estado
        
    }
    

    @Override
    public String importaCVS( String nomeFicheiro ){
        return " ";
    }

    @Override
    public String gravaEstadoApp( Data data, String nomeFicheiro ){ 
        return Ficheiro.gravaParaBinario(data, nomeFicheiro).toString();
    }

    @Override
    public Data carregaEstadoApp( String nomeFicheiro ){
        return Ficheiro.carregaDeBinario(nomeFicheiro);
    }

    
    @Override
    public void alteraModoConfiguracao(int op) {
    }


    @Override
    public boolean voltar() {
        return true;
    }

    @Override
    public void avancaEstado() {  }



        @Override
    public boolean fechaEstado() {
        return false;
    }


    @Override
    public boolean getSituacaoEstado(){
        return true;
    }


    @Override
    public ApoioPoeState getState() {
        return null;
    }








    





}
