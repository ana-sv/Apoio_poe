package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;


public class ApoioPoeUiText {
    ApoioPoeContext poe; 


    public ApoioPoeUiText( ApoioPoeContext poe ){
        this.poe = poe; 
    }

    private boolean finish = false;





    private void consultaUI(){

    }

    private void atribuicaoOrientadoresUI(){

    }


    private void atribuicaoPorpostasUI(){

    }


    private void organizaEmpateUI(){

    }

    private void organizaCandidaturasUI(){

    }

    


    private void aguardaConfiguracaoUI(){

    }



    private void modoPropostasUI(){


    }

    
    private void modoDocentesUI(){

    }



    private void modoAlunosUI(){


    }


    public void start(){
        while( !finish ){

            switch( poe.getState() ){
                case MODO_ALUNOS -> modoAlunosUI();
                case MODO_DOCENTES -> modoDocentesUI();
                case MODO_PROPOSTAS -> modoPropostasUI(); 
                case AGUARDA_CONFIGURACAO -> aguardaConfiguracaoUI();
                case ORGANIZA_CANDIDATURAS -> organizaCandidaturasUI();
                case ORGANIZA_EMPATE -> organizaEmpateUI();
                case ATRIBUICAO_PROPOSTAS -> atribuicaoPorpostasUI();
                case ATRIBUICAO_ORIENTADORES -> atribuicaoOrientadoresUI();
                case CONSULTA -> consultaUI();

            }


        }

    }





    
}
