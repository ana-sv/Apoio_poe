package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class AtribuicaoPropostas extends StateAdapter {
    private Integer id = 2;

    AtribuicaoPropostas(ApoioPoeContext context, Data data) {
        super(context, data);
    }

    public boolean atribuicaoAuto() {

        if (data.getSituacaoEstados(id) == true) { // se esta fase está aberta , entao começa a atribuir

            for (Candidatura a : data.getListaCandidaturas().values()) {

                if (!data.alunoExisteListaFinal(a.getNumEstudante())) { // se o aluno ainda nao está na lista final
                                                                        // definitiva

                    if ( a.getListaPropostas().contains("T3")) {
                        data.getListaFinal().put(a.getNumEstudante(), a.getCodigoProposta(0));
                         // a lista de propostas já é um array com codigos das propostas
                         data.getListaCandidaturas().remove(a.getNumEstudante());  
                    }

                }  else {


                     // SE o proximo aluno tem a mesma primeira opção que outros na lista 
                      // e se for estágio ve se tem nota para tal , se não tiver nota testa a segunda opção 

                     // adiciona-nos na lista de empates 
                     // vai ao estado desempatar e volta?

                     // SE nao , atribui a primeira opção 



                }


     


            }

        }

        return false; // "Estado Fechado, nao pode fazer nada disto

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

        // REVER

        // Apenas será possível fechar esta fase se todos os alunos com candidaturas
        // submetidas possuírem projeto atribuído
        if (data.getListaCandidaturas().containsValue(null)) {
            data.setSituacaoEstados( this.id, false); 
            return false;
        } else {
            changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
            return true;
        }
    }

    @Override
    public boolean voltar() {
        if (data.getSituacaoEstados(this.id) == true) {
            changeState(ApoioPoeState.OPCOES_CANDIDATURAS);
            return true;
        }
        return false;

    }

    @Override
    public boolean getSituacaoEstado() {
        return data.getSituacaoEstados(this.id);
    }

}
