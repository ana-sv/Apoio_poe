package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

/*

NOTAS DE IMPLEMENTAÇAO 

Default: When no access modifier is specified for a class, method, or data member 
– It is said to be having the default access modifier by default. 

The data members, class or methods which are not declared using any
access modifiers i.e. having default access modifier are accessible only within the same package.


*/

class AguardaConfiguracao extends ApoioPoeStateAdapter {
    Fase fase;

    AguardaConfiguracao(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;

    }

    @Override
    public String mostraListas() {
        // TO DO
        return " nao implementado ainda";
    }


    @Override
    public String exportaCVS(String nomeFicheiro) {
        // TODO
        return " nao implementado ainda";
    }

    @Override
    public String filtraListas() {
        // TO DO
        return " nao implementado ainda";
    }


    public void classificaAlunos() {
        // TO DO - META 2
    }


    @Override
    public void avanca() { // avanca sem fechar fase

        // classificaAlunos() 
        changeState(ApoioPoeState.ORGANIZA_CANDIDATURAS);
    }

    @Override
    public boolean fechaFase() { // avança e fecha fase

        // classificaAlunos()

        if (data.contaPropostas() >= data.contaAlunos()) {
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
