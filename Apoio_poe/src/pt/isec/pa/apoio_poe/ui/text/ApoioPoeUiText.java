package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeIState;
import pt.isec.pa.apoio_poe.ui.utils.PAInput;

public class ApoioPoeUiText {
    ApoioPoeContext poe;
    private boolean finish;

    public ApoioPoeUiText(ApoioPoeContext poe) {
        this.poe = poe;
        finish = false;
    }

    // opcoes do utilizardor em cada fase

    private void consultaUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Apresenta lista de Informacoes", "Exporta Informacoes  ", "Gravar Estado Aplicacao ", "Sair")) {
            // case 1 -> lista com filtros
            // case 2 -> TO DO EXPORTA
            // case 3-> TO DO gravar estado a aplicacao
            case 4 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void atribuicaoOrientadoresUI() {
        if (poe.getFase()== "ABERTA") {  
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes  ", "Atribuicao Automatica de Orientadores","Voltar",
                    "Avancar", "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ", "Sair")) {
                // case 1 -> lista com filtros
                // case 2 -> TO DO EXPORTA
                // case 3 -> TO DO atribuicao automatica de orientadores
                case 4 -> poe.volta(); 
                case 5 -> poe.avanca();
                case 6 -> poe.avancaFechandoFase(); // adicionar condicao que so pode fechar quando todas as
                                                    // candidaturas estao lacradas !
                // case 7-> TO DO gravar estado a aplicacao
                case 8 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Avancar", "Gravar Estado Aplicacao ",
                    "Sair")) {
                // case 1 -> lista com filtros
                // case 2 -> TO DO EXPORTA
                case 3 -> poe.avanca();
                // case 4-> TO DO gravar estado a aplicacao
                case 5 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        }
    }

    private void atribuicaoPorpostasUI() {
        if (poe.getFase()== "ABERTA") {  
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Atribuicao Automatica de Propostas", "Voltar",
                    "Avancar", "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ", "Sair")) {
                // case 1 -> lista com filtros
                // case 2 -> TO DO EXPORTA
                // case 3 -> TO DO atribuicao automatica de ppropostas
                case 4 -> poe.volta(); 
                case 5 -> poe.avanca();
                case 6 -> poe.avancaFechandoFase();
                // case 7-> TO DO gravar estado a aplicacao
                case 8 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Avancar", "Gravar Estado Aplicacao ",
                    "Sair")) {
                // case 1 -> lista com filtros
                // case 2 -> TO DO EXPORTA
                case 3 -> poe.avanca();
                // case 4-> TO DO gravar estado a aplicacao
                case 5 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        }
    }

    private void resolveEmpateUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Apresenta lista de Informacoes", "Resolver Empates", "Avancar", "Gravar Estado Aplicacao ", "Sair")) {
            // case 1 -> lista com filtros
            // case 2 -> resolver empates
            case 3 -> poe.avanca();
            // case 4-> TO DO gravar estado a aplicacao
            case 5 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void organizaCandidaturasUI() {
        if (poe.getFase()== "ABERTA") {  
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Lista Candidaturas", "Importa Info Candidaturas",
                    "Exporta Info Candidaturas ", "Voltar" , "Avancar", "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ",
                    "Sair")) {
                // case 1 -> lista com filtros
                // case 2 -> TO DO IMPORTA
                // case 3 -> TO DO EXPORTA
                case 4 -> poe.volta(); 
                case 5 -> poe.avanca();
                case 6 -> poe.avancaFechandoFase();
                // case 7-> TO DO gravar estado a aplicacao
                case 8 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes Candidaturas ", "Avancar",
                    "Gravar Estado Aplicacao ", "Sair")) {
                // case 1 -> lista com filtros
                // case 2 -> TO DO EXPORTA
                case 3 -> poe.avanca();
                // case 4-> TO DO gravar estado a aplicacao
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
            // case 3 -> exportar
            case 4 -> poe.avanca();
            // case 5-> TO DO gravar estado a aplicacao
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
           //  case 3 -> 
            case 4 -> poe.avanca();
            // case 5-> TO DO gravar estado a aplicacao
            case 6 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void modoAlunosUI() {
        switch (PAInput.chooseOption("Escolha uma opcao: ",
                "Lista de Alunos", "Importar info Alunos", "Exportar info Alunos", "Avancar", "Gravar Estado Aplicacao ", "Sair")) {
             case 1 -> System.out.println(poe.mostraListas());
             case 2 -> System.out.println(poe.importaCVS(   PAInput.readString("> Insira nome do ficheiro: ", true )));
            // case 3 -> exportar
            case 4 -> poe.avanca();
            // case 5-> TO DO gravar estado a aplicacao
            case 6 -> finish = true;
            default -> System.out.println("Escolha uma opcao!");
        }

    }

    private void aguardaConfiguracaoUI() {
        if (poe.getFase()== "ABERTA") {  
            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Atualizar Alunos", "Atualizar Docentes", "Atualizar Propostas", "Apresenta lista de Informacoes",
                    "Exporta Informacoes ", "Avancar",
                    "Avancar [Fechando Fase]", "Gravar Estado Aplicacao ", "Sair")) {
                case 1 -> poe.alteraModoConfiguracao(1);
                case 2 -> poe.alteraModoConfiguracao(2);
                case 3 -> poe.alteraModoConfiguracao(3);
                // case 4 -> lista com filtros
                // case 5 -> TODO exportar info
                case 6 -> poe.avanca();
                case 7 -> poe.avancaFechandoFase(); // ADICIONAR CONDICAO Q SO FECHAS SE nAlunos <= n Propostas
                // case 8-> TO DO gravar estado a aplicacao
                case 9 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }

        } else {

            switch (PAInput.chooseOption("Escolha uma opcao: ",
                    "Apresenta lista de Informacoes", "Exporta Informacoes ", "Avancar", "Gravar Estado Aplicacao ",
                    "Sair")) {
                // case 1 -> lista com filtros
                // case 2 -> TODO exportar info
                case 3 -> poe.avanca();
                // case 4-> TO DO gravar estado a aplicacao
                case 5 -> finish = true;
                default -> System.out.println("Escolha uma opcao!");
            }
        }
    }

    public void start() {

        
            System.out.println();
            System.out.println("************ Apoio à gestao de projetos e estágios ************ ");

        while (!finish) {


            if (poe.getFase() == null)
                System.out.print("\n>>>>>>>>>>>>>>>>>>> Estado: " + poe.getState());
            else
                System.out.print("\n>>>>>>>>>>>>>>>>>>> Estado: " + poe.getState() + " > Fase: " + poe.getFase());

            System.out.println();

            switch (poe.getState()) {
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
