package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeIState.Fase;
import pt.isec.pa.apoio_poe.ui.utils.PAInput;

public class ApoioPoeUiText {
    ApoioPoeContext poe;
    private boolean finish;

    public ApoioPoeUiText(ApoioPoeContext poe) {
        this.poe = poe;
        finish = false;
    }

    // opcoes do utilizador em cada fase

    private void consultaUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Apresenta lista de Informacoes", "Exporta Informacoes  ", "Gravar Estado Aplicacao ", "Sair")) {
            case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
            case 2 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
            case 3 -> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
            case 4 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void atribuicaoOrientadoresUI() {
        if (poe.getFaseEnum()== Fase.ABERTA) {   
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes  ", "Atribuicao Automatica de Orientadores","Voltar",
                    "Avancar", "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ", "Sair")) {
                case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
                case 2 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                // case 3 -> TO DO atribuicao automatica de orientadores
                case 4 -> poe.volta(); 
                case 5 -> poe.avanca();
                case 6 -> System.out.println("\nFASE FECHADA: " + poe.avancaFechandoFase() );
                 case 7-> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 8 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Avancar", "Gravar Estado Aplicacao ",
                    "Sair")) {
                case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
                 case 2 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                case 3 -> poe.avanca();
                case 4->System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 5 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        }
    }

    private void atribuicaoPorpostasUI() {
        if (poe.getFaseEnum()== Fase.ABERTA) {  
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Atribuicao Automatica de Propostas", "Voltar",
                    "Avancar", "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ", "Sair")) {
                case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
                 case 2 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                // case 3 -> TO DO atribuicao automatica de ppropostas
                case 4 -> poe.volta(); 
                case 5 -> poe.avanca();
                case 6 -> System.out.println("\nFASE FECHADA: " + poe.avancaFechandoFase() );
                case 7-> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 8 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Avancar", "Gravar Estado Aplicacao ",
                    "Sair")) {
                case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
                case 2 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                case 3 -> poe.avanca();
                case 4 -> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 5 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        }
    }

    private void resolveEmpateUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Apresenta lista de Informacoes", "Resolver Empates", "Avancar", "Gravar Estado Aplicacao ", "Sair")) {
             case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
            // case 2 -> resolver empates
            case 3 -> poe.avanca();
             case 4-> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
            case 5 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void opcoesCandidaturasUI() {
        if (poe.getFaseEnum()== Fase.ABERTA) {  
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Lista Candidaturas", "Importa Info Candidaturas",
                    "Exporta Info Candidaturas ", "Voltar" , "Avancar", "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ",
                    "Sair")) {
                case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
                 case 2 -> System.out.println(poe.importaCVS(   PAInput.readString("> Insira nome do ficheiro: ", true )));
                 case 3 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                case 4 -> poe.volta(); 
                case 5 -> poe.avanca();
                case 6 -> System.out.println("\nFASE FECHADA: " + poe.avancaFechandoFase() );
                case 7 -> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 8 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes Candidaturas ", "Avancar",
                    "Gravar Estado Aplicacao ", "Sair")) {
                 case 1 -> System.out.println(poe.filtraListas(   PAInput.readString("> Insira filtros ", false ) ) );
                case 2 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                case 3 -> poe.avanca();
                 case 4-> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 5 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        }
    }

    private void modoPropostasUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Lista de Propostas", "Importar info Propostas", "Exportar info Propostas", "Avancar",
                "Gravar Estado Aplicacao ", "Sair")) {
            case 1 -> System.out.println(poe.mostraListas());
            case 2 -> System.out.println(poe.importaCVS(   PAInput.readString("> Insira nome do ficheiro: ", true )));
            case 3 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
            case 4 -> poe.avanca();
            case 5 -> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
            case 6 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void modoDocentesUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Lista de Docentes", "Importar info Docentes", "Exportar info Docentes", "Avancar",
                "Gravar Estado Aplicacao ", "Sair")) {
            case 1 -> System.out.println(poe.mostraListas());
            case 2 -> System.out.println(poe.importaCVS(   PAInput.readString("> Insira nome do ficheiro: ", true )));
            case 3 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true ))); 
            case 4 -> poe.avanca();
            case 5 -> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
            case 6 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void modoAlunosUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Lista de Alunos", "Importar info Alunos", "Exportar info Alunos", "Avancar", "Gravar Estado Aplicacao ", "Sair")) {
             case 1 -> System.out.println(poe.mostraListas());
             case 2 -> System.out.println(poe.importaCVS(   PAInput.readString("> Insira nome do ficheiro: ", true )));
             case 3 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
            case 4 -> poe.avanca();
             case 5-> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
            case 6 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void aguardaConfiguracaoUI() {
        if (poe.getFaseEnum()== Fase.ABERTA) {  
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Atualizar Alunos", "Atualizar Docentes", "Atualizar Propostas", "Exporta Informacoes ", "Avancar",
                    "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ", " Carregar Estado da Aplicacao ", "Sair")) {
                case 1 -> poe.alteraModoConfiguracao(1);
                case 2 -> poe.alteraModoConfiguracao(2);
                case 3 -> poe.alteraModoConfiguracao(3);
                case 4 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                case 5 -> poe.avanca();
                case 6 -> System.out.println("\nFASE FECHADA: " + poe.avancaFechandoFase() );
                case 7 -> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 8 -> System.out.println("\nNAO IMPLEMENTADO "); 
                case 9 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Avancar", "Gravar Estado Aplicacao ", " Carregar Estado da Aplicacao ","Sair")) {
                case 1 -> System.out.println(poe.mostraListas());
                case 4 -> System.out.println(poe.exportaCVS(   PAInput.readString("> Insira um nome para ficheiro: ", true )));
                case 3 -> poe.avanca();
                case 7 -> System.out.println( poe.gravaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true )) ); 
                case 8 -> System.out.println(poe.carregaEstadoAplicacao(PAInput.readString("> Insira um nome para ficheiro: ", true ))); 
                case 5 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }
        }
    }

    public void start() {

        
            System.out.println();
            System.out.println("************ Apoio à gestao de projetos e estágios ************ ");

        while (!finish) {


            if (poe.getFaseEnum() == null)
                System.out.print("\n>>>>>>>>>>>>>>>>>>> Estado: " + poe.getState());
            else
                System.out.print("\n>>>>>>>>>>>>>>>>>>> Estado: " + poe.getState() + " > Fase: " + poe.getFase());

            System.out.println();

            switch (poe.getState()) {
                case AGUARDA_CONFIGURACAO -> aguardaConfiguracaoUI();

                case MODO_ALUNOS -> modoAlunosUI();
                case MODO_DOCENTES -> modoDocentesUI();
                case MODO_PROPOSTAS -> modoPropostasUI();

                case OPCOES_CANDIDATURAS -> opcoesCandidaturasUI();

                case ATRIBUICAO_PROPOSTAS -> atribuicaoPorpostasUI();
                case RESOLVE_EMPATES -> resolveEmpateUI();

                case ATRIBUICAO_ORIENTADORES -> atribuicaoOrientadoresUI();
                case CONSULTA -> consultaUI();

            }

        }

    }

}
