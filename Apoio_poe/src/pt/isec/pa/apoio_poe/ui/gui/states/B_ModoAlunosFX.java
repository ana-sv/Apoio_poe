package pt.isec.pa.apoio_poe.ui.gui.states;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.InputWindow;

public class B_ModoAlunosFX extends BorderPane {
    ModelManager manager;

    Button btnImportar, btnExportar;
    Button btnVoltar, btnAvancar;

    VBox vboxOpcoes;
    VBox vboxTable;


    TableView<Aluno> table;
    ObservableList<Aluno> obList;


    public B_ModoAlunosFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {
        btnImportar = new Button("Importar Lista de Alunos");
        btnImportar.setMinSize(150, 60);

        btnExportar = new Button("Exportar Lista Alunos");
        btnExportar.setMinSize(150, 60);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinSize(150, 60);

        btnVoltar = new Button("Voltar");
        btnVoltar.setMinSize(150, 60);

        // TO DO : Desencostar os botoes da borda direita um bocadinho
        vboxOpcoes = new VBox();
        vboxOpcoes.getChildren().addAll(btnImportar, btnExportar, btnAvancar, btnVoltar);
        this.setRight(vboxOpcoes);
        vboxOpcoes.setAlignment(Pos.CENTER);

        // TO DO : Lista Editável do lado esquerdo  
        vboxTable = new VBox();
        vboxTable.setAlignment(Pos.CENTER_LEFT);
        this.setCenter(vboxTable);


        table = new TableView<>();

        TableColumn<Aluno,Long> cNumero = new TableColumn<>("Numero Aluno");
        cNumero.setCellValueFactory(new PropertyValueFactory<>("numEstudante"));
        cNumero.setMinWidth(100);
        table.getColumns().add(cNumero);

        TableColumn<Aluno, String> cNome = new TableColumn<>("Nome");
        cNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        table.getColumns().add(cNome);
        
        TableColumn<Aluno, String> cMail = new TableColumn<>("Mail");
        cMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        table.getColumns().add(cMail);
        
        TableColumn<Aluno, String> cCurso = new TableColumn<>("Curso");
        cCurso.setCellValueFactory(new PropertyValueFactory<>("siglaCurso"));
        table.getColumns().add(cCurso);

        TableColumn<Aluno, String> cRamo = new TableColumn<>("Nome");
        cRamo.setCellValueFactory(new PropertyValueFactory<>("siglaRamo"));
        table.getColumns().add(cRamo);

        TableColumn<Aluno, String> cClas = new TableColumn<>("Classificação");
        cClas.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        table.getColumns().add(cCurso);

        TableColumn<Aluno, String> cEstagio = new TableColumn<>("Acesso a Estagio");
        cEstagio.setCellValueFactory(new PropertyValueFactory<>("estagioAcesso"));
        cEstagio.setMinWidth(100);
        table.getColumns().add(cEstagio);


        table.setItems(obAlunos(manager.getArrayAlunos()));
        vboxTable.getChildren().addAll(table);

    }

    private void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            


            update();
        });

        btnImportar.setOnAction(event -> {
            String str = InputWindow.display("Importar Lista de Alunos", "Insira o nome do ficheiro a importar: ");
            System.out.println("nome do ficheiro importar " + str);
            manager.importaCVS(str);
        });

        btnExportar.setOnAction(event -> {
            String str = InputWindow.display("Ixportar Lista de Alunos",
                    "Insira o nome do ficheiro para exportação:  ");
            System.out.println("nome ficheiro exportar " + str);
            manager.exportaCVS(str, manager.listaAlunos());
        });

        btnAvancar.setOnAction(event -> {
            manager.avancaEstado();
        });
        btnVoltar.setOnAction(event -> {
            manager.volta();
        });

    }

    private void update() {
        if (manager.getState() != ApoioPoeState.MODO_ALUNOS) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

    }




    
    public ObservableList<Aluno> obAlunos(ArrayList<Aluno> list) {

        for (Aluno a : list){
            obList.add(a);
        }

        System.out.println(" aqui ");
        return obList;

    }


    
}
