package pt.isec.pa.apoio_poe.model.fsm.states;


import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;



class AguardaConfiguracao extends ApoioPoeStateAdapter {
    Fase fase;

    AguardaConfiguracao(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;

    }

    @Override
    public String mostraListas() {

        StringBuilder s = new StringBuilder();

            s.append("\n> Lista Alunos ");
            for ( Aluno a : data.getListaAlunos().values()) {
                s.append(a.alunoToString());
            }
            s.append("\n");

            s.append("\n> Lista Docentes ");
            for ( Docente a : data.getListaDocentes().values()) {
                s.append(a.DocentesToString());
            }
            s.append("\n");
    
            s.append("\n> Lista Propostas ");
            for ( Proposta a : data.getListaProposta().values()) {
                s.append(a.propostasToString());
            }
            s.append("\n");

        return s.toString();
    }



    public void classificaAlunos() {
        // TO DO - META 2
    }

    @Override
    public void avanca() { // avanca sem fechar fase

        // classificaAlunos()
        changeState(ApoioPoeState.OPCOES_CANDIDATURAS);
    }

    @Override
    public boolean fechaFase() { // avança e fecha fase

        // classificaAlunos()

        if (data.contaPropostasDA() >= data.getListaAlunos().size()
                && data.contaPropostasSI() >= data.getListaAlunos().size()
                && data.contaPropostasRAS() >= data.getListaAlunos().size()) { 
            fase = Fase.FECHADA;
            return true;
        }

        return false;
    }

    @Override
    public boolean alteraModoConfiguracao(int op) {
        switch (op) {
            case 1 -> changeState(ApoioPoeState.MODO_ALUNOS);
            case 2 -> changeState(ApoioPoeState.MODO_DOCENTES);
            case 3 -> changeState(ApoioPoeState.MODO_PROPOSTAS);
            default -> {
                return false;
            }
        }
        return false;
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.AGUARDA_CONFIGURACAO;
    }

    public Fase getFase() {
        return fase;
    }

}
