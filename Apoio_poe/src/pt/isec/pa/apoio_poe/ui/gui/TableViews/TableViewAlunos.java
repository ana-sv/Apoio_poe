package pt.isec.pa.apoio_poe.ui.gui.TableViews;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LongStringConverter;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.data.Aluno;

public class TableViewAlunos extends VBox {
    ModelManager manager;

    private TableView<Aluno> table;
    private TableColumn<Aluno, Long> numEstudante;
    private TableColumn<Aluno, String> nome;
    private TableColumn<Aluno, String> mail;
    private TableColumn<Aluno, String> curso;
    private TableColumn<Aluno, String> ramo;
    private TableColumn<Aluno, Double> classificacao;
    private TableColumn<Aluno, Boolean> estagio;

    private Scene scene;
    private Stage stage;

    ObservableList<Aluno> observableList ;
    public TableViewAlunos(ModelManager manager, Boolean edit) {
        this.manager = manager;

        table = new TableView<Aluno>();

        table.setEditable(edit);

        numEstudante = new TableColumn<Aluno, Long>("Numero Estudante");
        numEstudante.setCellValueFactory(new PropertyValueFactory<Aluno, Long>("numEstudante"));
        numEstudante.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        numEstudante.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, Long>>() {
            @Override
            public void handle(CellEditEvent<Aluno, Long> event) {
                Aluno aluno = event.getRowValue();
                aluno.setNumEstudante(event.getNewValue());
            }
        });
        table.getColumns().add(numEstudante);

        nome = new TableColumn<Aluno, String>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
        nome.setCellFactory(TextFieldTableCell.forTableColumn());
        nome.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, String>>() {
            @Override
            public void handle(CellEditEvent<Aluno, String> event) {
                Aluno aluno = event.getRowValue();
                aluno.setNome(event.getNewValue());
            }
        });
        table.getColumns().add(nome);

        mail = new TableColumn<Aluno, String>("Mail");
        mail.setCellValueFactory(new PropertyValueFactory<Aluno, String>("mail"));
        mail.setCellFactory(TextFieldTableCell.forTableColumn());
        mail.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, String>>() {
            @Override
            public void handle(CellEditEvent<Aluno, String> event) {
                Aluno aluno = event.getRowValue();
                aluno.setMail(event.getNewValue());
            }
        });
        table.getColumns().add(mail);

        curso = new TableColumn<Aluno, String>("Curso");
        curso.setCellValueFactory(new PropertyValueFactory<Aluno, String>("siglaCurso"));
        curso.setCellFactory(TextFieldTableCell.forTableColumn());
        curso.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, String>>() {
            @Override
            public void handle(CellEditEvent<Aluno, String> event) {
                Aluno aluno = event.getRowValue();
                aluno.setSiglaCurso(event.getNewValue());
            }
        });
        table.getColumns().add(curso);

        ramo = new TableColumn<Aluno, String>("Ramo");
        ramo.setCellValueFactory(new PropertyValueFactory<Aluno, String>("siglaRamo"));
        ramo.setCellFactory(TextFieldTableCell.forTableColumn());
        ramo.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, String>>() {
            @Override
            public void handle(CellEditEvent<Aluno, String> event) {
                Aluno aluno = event.getRowValue();
                aluno.setSiglaRamo(event.getNewValue());
            }
        });
        table.getColumns().add(ramo);

        classificacao = new TableColumn<Aluno, Double>("Classificação");
        classificacao.setCellValueFactory(new PropertyValueFactory<Aluno, Double>("classificacao"));
        classificacao.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        classificacao.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, Double>>() {
            @Override
            public void handle(CellEditEvent<Aluno, Double> event) {
                Aluno aluno = event.getRowValue();
                aluno.setClassifica(event.getNewValue());
            }
        });
        table.getColumns().add(classificacao);

        estagio = new TableColumn<Aluno, Boolean>("Acesso Estagio");
        estagio.setCellValueFactory(new PropertyValueFactory<Aluno, Boolean>("acessoEstagio"));
        estagio.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        estagio.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, Boolean>>() {
            @Override
            public void handle(CellEditEvent<Aluno, Boolean> event) {
                Aluno aluno = event.getRowValue();
                aluno.setAcessoEstagio(event.getNewValue());
            }
        });
        table.getColumns().add(estagio);

       observableList = FXCollections.observableList(manager.getArrayAlunos());
        table.getItems().addAll(observableList);

        observableList.addListener(
            new ListChangeListener<Aluno>() {
              @Override
              public void onChanged(
                Change<? extends Aluno> change) {
                  System.out.println(
                    "Selection changed: " + change.getList());
                }
          });

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        getChildren().add(table);

    }



    public void displayTableAlunos() {

        scene = new Scene(new BorderPane(table), 500, 300);
        stage = new Stage();
        stage.setTitle("Listagem de Alunos");
        stage.setScene(scene);
        stage.show();

    }


    public void updateTable(){
        observableList = FXCollections.observableList(manager.getArrayAlunos());
        table.getItems().addAll(observableList);


    }



}
