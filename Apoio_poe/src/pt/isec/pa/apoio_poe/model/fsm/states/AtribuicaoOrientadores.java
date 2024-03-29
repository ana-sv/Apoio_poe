package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class AtribuicaoOrientadores extends StateAdapter {
    private Integer id = 3;

    AtribuicaoOrientadores(ApoioPoeContext context, Data data) {
        super(context, data);

    }

    public String mostraListas() { // MUDAR PARA DADOS?
        StringBuilder s = new StringBuilder();
        s.append(data.infoCandidaturasToString(true));

        return s.toString();
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.ATRIBUICAO_ORIENTADORES;
    }

    @Override
    public void avancaEstado() {
      //  if (fechaEstado()) { // porque avançando para o estado Consulta ano é possivel voltar atrás
            changeState(ApoioPoeState.CONSULTA);
       // }
    }

    @Override
    public boolean voltar() {

        if (data.getSituacaoEstados(this.id) == true) {
            changeState(ApoioPoeState.ATRIBUICAO_PROPOSTAS);
            return true;
        }
        return false;

    }

    @Override
    public boolean fechaEstado() {
        if (data.getListaAlunos().size() == data.getListaFinal().size()) { // todos os alunos tem uma proposta atribuida

            data.setSituacaoEstados(id, false);
            return true;
        }
        return false;

    }

    @Override
    public boolean getSituacaoEstado() {
        return data.getSituacaoEstados(this.id);
    }

}
