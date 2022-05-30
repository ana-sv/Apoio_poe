package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

class AtribuicaoPropostas extends ApoioPoeStateAdapter{
    private Integer index = 2;


 AtribuicaoPropostas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }

    public boolean atribuicaoAuto(){
         // se fase aberta --> atribui automaticamente 
                // se existem empates   changeState(ApoioPoeState.RESOLVE_EMPATES);
                // se nao exitem    continua no mesmo estado
                
            return false; 

    }

    public String filtraListasAlunos( Integer q ,String filtros ) {
        // TO DO
        return " nao implementado ainda";
    }

  
    public String filtraListasPropostas( Integer q ,String filtros ) {
        // TO DO
        return " nao implementado ainda";
    }


    public String mostraListas() {   // MUDAR PARA DADOS??
        StringBuilder s = new StringBuilder();

        s.append(data.infoCandidaturasToString(false));

    return s.toString();
    }



    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.ATRIBUICAO_PROPOSTAS;
    }

    @Override
    public void avancaEstado() {
        changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
    }

    @Override
    public boolean fechaEstado() {
        //TODO 
        // if(nCandidaturas=nPropostas ){
         //   data.setSituacaoEstados(this.index) = false; 
      //    changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
      //      return true;   }

        return false;
    }

    @Override
    public boolean voltar() {
        if (data.getSituacaoEstados(this.index) == true) {
            changeState(ApoioPoeState.OPCOES_CANDIDATURAS);
            return true;
        }
        return false; 

    }


    @Override
    public boolean getSituacaoEstado(){
        return data.getSituacaoEstados(this.index);
    }


    
}
