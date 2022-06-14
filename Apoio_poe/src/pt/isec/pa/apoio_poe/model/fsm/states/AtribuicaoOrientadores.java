package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class AtribuicaoOrientadores extends StateAdapter {
    private Integer index = 3;

    AtribuicaoOrientadores(Context context, ApoioPoeData data) {
        super(context, data);

    }

    public String filtraListasOrientadores(Integer q, String filtros) { // MUDAR PARA DADOS?
        // TO DO
        return " nao implementado ainda";
    }

    public String mostraListas() { // MUDAR PARA DADOS?
        StringBuilder s = new StringBuilder();
        s.append(data.infoCandidaturasToString(true));

        return s.toString();
    }

    @Override
    public State getState() {
        return State.ATRIBUICAO_ORIENTADORES;
    }

    @Override
    public void avancaEstado() {
        if (fechaEstado()) { // porque avançando para o estado Consulta ano é possivel voltar atrás
            changeState(State.CONSULTA);
        }
    }

    @Override
    public boolean voltar() {

        if (data.getSituacaoEstados(this.index) == true) {
            changeState(State.ATRIBUICAO_PROPOSTAS);
            return true;
        }
        return false;

    }

    @Override
    public boolean fechaEstado() {
        if (data.getListaAlunos().size() == data.getListaAtribuidos().size()) { // todos os alunos tem uma proposta atribuida

            data.setSituacaoEstados(index, false);
            return true;
        }
        return false;

    }

    @Override
    public boolean getSituacaoEstado() {
        return data.getSituacaoEstados(this.index);
    }

}
