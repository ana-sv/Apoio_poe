package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;



public abstract class ApoioPoeStateAdapter implements ApoioPoeIState{
    protected ApoioPoeContext context;
    protected ApoioPoeData data; 


    protected ApoioPoeStateAdapter(ApoioPoeContext context, ApoioPoeData data) {
        this.context = context;
        this.data = data; 
    }


    protected void changeState( ApoioPoeState newState ){
        context.changeState(newState.createState(context,data));
    }
    
 
    @Override
    public String exportaCVS( String nomeFicheiro) {       // está aqui porque todos os estados se servem dela 
      //  return Ficheiro.exportaCVS(nomeFicheiro, mostraListas() );  //exporta de acordo com as informações de cada estado
        return " ";
    }
    

    @Override
    public String importaCVS( String nomeFicheiro ){
        return " ";
    }

    @Override
    public String gravaEstadoApp( ApoioPoeContext contexto , String nomeFicheiro ){ 
        return Ficheiro.gravaParaBinario(contexto, nomeFicheiro).toString();
    }

    @Override
    public ApoioPoeContext carregaEstadoApp( String nomeFicheiro ){
        return Ficheiro.carregaDeBinario(nomeFicheiro);
    }

    
    @Override
    public boolean alteraModoConfiguracao(int op) {
        return false;
    }


    @Override
    public boolean voltar() {
        return false;
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
