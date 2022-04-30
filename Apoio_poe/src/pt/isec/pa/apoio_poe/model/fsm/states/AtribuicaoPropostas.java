package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;
import pt.isec.pa.apoio_poe.model.data.Enum.Fase;

class AtribuicaoPropostas extends ApoioPoeStateAdapter{
    Fase fase;

 AtribuicaoPropostas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;
    }

    public boolean atribuicaoAuto(){
         // se fase aberta --> atribui automaticamente 
                // se existem empates   changeState(ApoioPoeState.RESOLVE_EMPATES);
                // se nao exitem    continua no mesmo estado
                
            return false; 

    }

    @Override
    public String exportaCVS() {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String filtrarListas() {
        // TO DO
        return " nao implementado ainda";
    }


    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.ATRIBUICAO_PROPOSTAS;
    }

    @Override
    public void avanca() {
        changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
    }

    @Override
    public boolean fechaFase() {
        //TODO 
        // if(nCandidaturas=nPropostas ){
         //   fase = Fase.FECHADA;
      //    changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
      //      return true;   }

        return false;
    }

    @Override
    public boolean voltar() {
        if( fase == Fase.ABERTA ){
            changeState(ApoioPoeState.ORGANIZA_CANDIDATURAS);
            return true;
        }
        return false; 

    }


    
}
