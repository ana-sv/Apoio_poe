package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.data.Enum.Fase;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.ui.utils.PAInput;


public class ApoioPoeUiText {
    ApoioPoeContext poe; 
    private boolean finish;

    public ApoioPoeUiText( ApoioPoeContext poe ){
        this.poe = poe; 
        finish = false; 
    }

    // opcoes do utilizardor em cada fase 

    private void consultaUI(){


    }

    private void atribuicaoOrientadoresUI(){


    }


    private void atribuicaoPorpostasUI(){

    }


    private void resolveEmpateUI(){

    }

    private void organizaCandidaturasUI(){

    }

    





    private void modoPropostasUI(){
        if( poe.getFase() == Fase.ABERTA ){
            System.out.println(" 1 - Importa Informacoes de Propostas");
            System.out.println(" 2 - Exporta Informacoes de Propostas");
            System.out.println(" 3 - Avancar");
        }else {
            System.out.println(" 2 - Exporta Informacoes de Propostas");
            System.out.println(" 3 - Avancar");
        }


    }

    
    private void modoDocentesUI(){
        if( poe.getFase() == Fase.ABERTA ){
            System.out.println(" 1 - Importa Informacoes de Docentes");
            System.out.println(" 2 - Exporta Informacoes de Docentes");
            System.out.println(" 3 - Avancar");
        }else {
            System.out.println(" 2 - Exporta Informacoes de Docentes");
            System.out.println(" 3 - Avancar");
        }

    }



    private void modoAlunosUI(){
        if( poe.getFase() == Fase.ABERTA ){
            System.out.println(" 1 - Importa Informacoes de Alunos");
            System.out.println(" 2 - Exporta Informacoes de Alunos");
            System.out.println(" 3 - Avancar");
        }else {
            System.out.println(" 2 - Exporta Informacoes de Alunos");
            System.out.println(" 3 - Avancar");
        }
    }


    

    private void aguardaConfiguracaoUI(){
        if( poe.getFase() == Fase.ABERTA ){
            switch(PAInput.chooseOption("Escolha uma opcao: ",
            "Atualizar Alunos", "Atualizar Docentes","Atualizar Propostas",
            "Exporta Informacoes ", "Avanca", "Avança - Fechando Fase ")){
                case 1 -> poe.alteraModoConfiguracao(1);
                case 2 -> poe.alteraModoConfiguracao(2);
                case 3 -> poe.alteraModoConfiguracao(3);
             //   case 4 -> exportar info
                case 5 -> poe.avanca();
                case 6 -> poe.avancaFechandoFase();
                default -> System.out.println("Escolha uma opcao!" );
            }
            
        } else {

            switch(PAInput.chooseOption("Escolha uma opcao: ",
            "Exporta Informacoes ", "Avanca")){
             //   case 1 -> exportar info
                case 2 -> poe.avanca();
                default -> System.out.println("Escolha uma opcao!" );
            }
        }
    }





    public void start(){
        while( !finish ){
            System.out.println("---------- Apoio à gestao de projetos e estágios ----------");
            System.out.println(" --- " + poe.getState() + " Fase: " + poe.getFase() + " --- ");

            switch( poe.getState() ){
                 case AGUARDA_CONFIGURACAO -> aguardaConfiguracaoUI();

                case MODO_ALUNOS -> modoAlunosUI();
                case MODO_DOCENTES -> modoDocentesUI();
                case MODO_PROPOSTAS -> modoPropostasUI(); 
               
                case ORGANIZA_CANDIDATURAS -> organizaCandidaturasUI();

               
                case ATRIBUICAO_PROPOSTAS -> atribuicaoPorpostasUI();
                case RESOLVE_EMPATES -> resolveEmpateUI();

                case ATRIBUICAO_ORIENTADORES -> atribuicaoOrientadoresUI();
                case CONSULTA -> consultaUI();

            }


        }

    }





    
}
