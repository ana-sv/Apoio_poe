package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;
import pt.isec.pa.apoio_poe.model.data.Enum.Fase;


 class OrganizaCandidaturas extends ApoioPoeStateAdapter {
    Fase fase;

     OrganizaCandidaturas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;
    }

    // TODO

    // impportarInfoCandidaturas se fase aberta 
    // exportarInfoCandidaturas

    @Override
    public String filtrarListas() {
        // TODO LISTAS CANDIDATURAS
        return super.filtrarListas();
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

    
    @Override
    public String importaCVS(String nomeFicheiro) {
        // TODO Auto-generated method stub
        return super.importaCVS(nomeFicheiro);
    }









    
    
}
