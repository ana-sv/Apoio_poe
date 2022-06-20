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
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.data.Docente;

public class TableViewDocentes extends VBox {
    ModelManager manager;

    private TableView<Docente> table;

    private TableColumn<Docente, String> nome; 
    private TableColumn<Docente,String> mail; 

    private Scene scene;
    private Stage stage;

     private  ObservableList<Docente> observableList ;

    public TableViewDocentes(ModelManager manager, Boolean edit) {
        this.manager = manager;

        table = new TableView<Docente>();

        table.setEditable(edit);

        nome = new TableColumn<Docente, String>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<Docente, String>("nome"));
        nome.setCellFactory(TextFieldTableCell.forTableColumn());
        nome.setOnEditCommit(new EventHandler<CellEditEvent<Docente, String>>() {
            @Override
            public void handle(CellEditEvent<Docente, String> event) {
               Docente docente = event.getRowValue();
                docente.setNome(event.getNewValue());
            }
        });
        table.getColumns().add(nome);

        mail = new TableColumn<Docente, String>("Mail");
        mail.setCellValueFactory(new PropertyValueFactory<Docente, String>("mail"));
        mail.setCellFactory(TextFieldTableCell.forTableColumn());
        mail.setOnEditCommit(new EventHandler<CellEditEvent<Docente, String>>() {
            @Override
            public void handle(CellEditEvent<Docente, String> event) {
               Docente docente = event.getRowValue();
                docente.setNome(event.getNewValue());
            }
        });
        table.getColumns().add(mail);

      

       observableList = FXCollections.observableList(manager.getArrayDocentes());
        table.getItems().addAll(observableList);

        observableList.addListener(
            new ListChangeListener<Docente>() {
              @Override
              public void onChanged(
                Change<? extends Docente> change) {
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
        observableList = FXCollections.observableList(manager.getArrayDocentes());
        table.getItems().addAll(observableList);


    }



}
