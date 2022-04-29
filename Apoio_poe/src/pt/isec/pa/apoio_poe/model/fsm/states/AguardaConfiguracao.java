package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;
import pt.isec.pa.apoio_poe.model.data.Enum.Fase;

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
    public String filtrarListas() {
        // TODO 
        return super.filtrarListas();
    }


    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.AGUARDA_CONFIGURACAO;
    }

    @Override
    public boolean alteraModoConfiguracao(int op) {
        switch(op){
            case 1 -> changeState(ApoioPoeState.MODO_ALUNOS);
            case 2 -> changeState(ApoioPoeState.MODO_DOCENTES);
            case 3 -> changeState(ApoioPoeState.MODO_PROPOSTAS);
            default -> { return false; }
        }
        return false;
    }


    public void classificaAlunos(){
        // TODO 

    }



    @Override
    public void avanca(){ // avanca sem fechar fase 

        // classificaAlunos()

        changeState( ApoioPoeState.ORGANIZA_CANDIDATURAS);
    }

    @Override
    public boolean fechaFase() { // avança e fecha fase 

            // classificaAlunos() 

               //if( nPropostas >= nAlunos ){
               //  fase = FECHADA;
               // return true ; }

               return false; 
    }




    
}
