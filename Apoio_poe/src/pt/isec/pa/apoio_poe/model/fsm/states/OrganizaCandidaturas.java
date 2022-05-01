package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class OrganizaCandidaturas extends ApoioPoeStateAdapter {
    Fase fase;

     OrganizaCandidaturas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;
    }


    @Override
    public String exportaCVS(String nomeFicheiro) {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String filtraListas( String filtros ) {
        // TO DO
        return " nao implementado ainda";
    }

    @Override
    public String mostraListas() {
        // TO DO
        return " nao implementado ainda";
    }


    @Override
    public String importaCVS(String nomeFicheiro) {

        
        return " nao implementado ainda";
    }


    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.ORGANIZA_CANDIDATURAS;
    }



    @Override
    public boolean voltar(){ 
        if ( fase == Fase.ABERTA ){
            changeState( ApoioPoeState.AGUARDA_CONFIGURACAO );
            return true;
        }
        return false; 
    }


    @Override
    public void avanca() {
        changeState( ApoioPoeState.ATRIBUICAO_PROPOSTAS );
  
    }

    @Override
    public boolean fechaFase() {
        // TODO : impedir fechar se houverem candidaturas sem proposta 
        fase = Fase.FECHADA;
        return true;    
    }








    
    
}
