package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class AguardaConfiguracao extends StateAdapter {
    private Integer index = 0;

    AguardaConfiguracao(Context context, Data data) {
        super(context, data);
    }



    @Override
    public void avancaEstado() { // avanca sem fechar/bloquear estado

        data.sortByClassification();
        changeState(State.OPCOES_CANDIDATURAS);
    }

    @Override
    public boolean fechaEstado() { // avança e fecha/bloquea estado

        data.sortByClassification();

        if (data.contaPropostasDA() >= data.getListaAlunos().size()
                && data.contaPropostasSI() >= data.getListaAlunos().size()
                && data.contaPropostasRAS() >= data.getListaAlunos().size()) {
            data.setSituacaoEstados(index, false);
            return true;
        }

        return false;
    }

    @Override
    public boolean alteraModoConfiguracao(int op) {
        switch (op) {
            case 1 -> changeState(State.MODO_ALUNOS);
            case 2 -> changeState(State.MODO_DOCENTES);
            case 3 -> changeState(State.MODO_PROPOSTAS);
            default -> {
                return false;
            }
        }
        return false;
    }

    @Override
    public State getState() {
        return State.AGUARDA_CONFIGURACAO;
    }

    @Override
    public boolean getSituacaoEstado() {
        return data.getSituacaoEstados(this.index);
    }

}
