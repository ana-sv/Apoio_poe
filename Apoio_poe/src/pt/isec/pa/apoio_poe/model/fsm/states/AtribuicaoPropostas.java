package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class AtribuicaoPropostas extends StateAdapter{
    private Integer index = 2;


 AtribuicaoPropostas(Context context, Data data) {
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
    public State getState() {
        return State.ATRIBUICAO_PROPOSTAS;
    }

    @Override
    public void avancaEstado() {
        changeState(State.ATRIBUICAO_ORIENTADORES);
    }

    @Override
    public boolean fechaEstado() {


        // Apenas será possível fechar esta fase se todos os alunos com candidaturas submetidas possuírem projeto atribuído
        if( data.getListaCandidaturas().containsValue(null)){
            return false; 
        }
        else{
            changeState(State.ATRIBUICAO_ORIENTADORES);
            return true; 
        }
    }

    @Override
    public boolean voltar() {
        if (data.getSituacaoEstados(this.index) == true) {
            changeState(State.OPCOES_CANDIDATURAS);
            return true;
        }
        return false; 

    }


    @Override
    public boolean getSituacaoEstado(){
        return data.getSituacaoEstados(this.index);
    }


    
}
