package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class A_AguardaConfiguracao extends StateAdapter {
    private Integer index = 0;

    A_AguardaConfiguracao(ApoioPoeContext context, Data data) {
        super(context, data);
    }



    @Override
    public void avancaEstado() { // avanca sem fechar/bloquear estado

        data.sortByClassification();
        changeState(ApoioPoeState.OPCOES_CANDIDATURAS);
    }

    @Override
    public boolean fechaEstado() { // avança e fecha/bloquea estado

        data.sortByClassification();

        if (data.contaPropostasDA() >= data.getListaAlunos().size()
                && data.contaPropostasSI() >= data.getListaAlunos().size()
                && data.contaPropostasRAS() >= data.getListaAlunos().size() && data.contaPropostasDA() != 0 ) {
            data.setSituacaoEstados(index, false);
            return true;
        }

        return false;
    }

    @Override
    public void alteraModoConfiguracao(int op) {
        switch (op) {
            case 1 -> changeState(ApoioPoeState.MODO_ALUNOS);
            case 2 -> changeState(ApoioPoeState.MODO_DOCENTES);
            case 3 -> changeState(ApoioPoeState.MODO_PROPOSTAS);
        }
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.AGUARDA_CONFIGURACAO;
    }

    @Override
    public boolean getSituacaoEstado() {
        return data.getSituacaoEstados(this.index);
    }

}
