package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

class AtribuicaoOrientadores extends ApoioPoeStateAdapter {
    Fase fase;

    AtribuicaoOrientadores(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;

    }

    // TO DO
    // Atribuicao automatica se fase=Fase.ABERTA
    // AtualizarOrientadores se fase=Fase.ABERTA

    @Override
    public String exportaCVS(String nomeFicheiro) {
        // TO DO
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
    public ApoioPoeState getState() {
        return ApoioPoeState.ATRIBUICAO_ORIENTADORES;
    }

    @Override
    public void avanca() {
        fechaFase();  // porque avançando para o estado Consulta ano é possivel voltar atrás 
        changeState(ApoioPoeState.ORGANIZA_CANDIDATURAS);
    }

    @Override
    public boolean voltar() {
        if (context.getFaseEnum() == Fase.ABERTA) {
            changeState(ApoioPoeState.ATRIBUICAO_PROPOSTAS);
            return true;
        }
        return false;

    }

    @Override
    public boolean fechaFase() {
        // falta certeficar aqui que todos os alunos tem uma candidatura com uma proposta
        fase = Fase.FECHADA;
        return true;
    }

}
