package pt.isec.pa.apoio_poe.ui.gui.TableViews;


import javafx.collections.FXCollections;
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
import javafx.util.converter.LongStringConverter;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.data.Candidatura;

public class TableViewCandidaturas extends VBox {
    ModelManager manager;

    private TableView<Candidatura> table;
    private TableColumn<Candidatura, Long> numEstudante;
    private TableColumn<Candidatura, String > codigoProp;

    private Scene scene;
    private Stage stage;

    ObservableList <Candidatura> observableList ;

    public TableViewCandidaturas(ModelManager manager, Boolean edit) {
        this.manager = manager;

        table = new TableView<Candidatura>();

        table.setEditable(edit);

        numEstudante = new TableColumn<Candidatura, Long>("Numero Estudante");
        numEstudante.setCellValueFactory(new PropertyValueFactory<Candidatura, Long>("numEstudante"));
        numEstudante.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        numEstudante.setOnEditCommit(new EventHandler<CellEditEvent<Candidatura, Long>>() {
            @Override
            public void handle(CellEditEvent<Candidatura, Long> event) {
                Candidatura c = event.getRowValue();
                c.setNumEstudante(event.getNewValue());
            }
        });
        table.getColumns().add(numEstudante);

      
      //  String a = manager.listaCandidaturas().toString();

        codigoProp = new TableColumn<Candidatura, String >("Codigos Propostas");
        codigoProp.setCellValueFactory(new PropertyValueFactory<Candidatura,String  >("numEstudante"));
        codigoProp.setCellFactory(TextFieldTableCell.forTableColumn());
        codigoProp.setOnEditCommit(new EventHandler<CellEditEvent<Candidatura, String>>() {
            @Override
            public void handle(CellEditEvent<Candidatura, String> event) {
                //Candidatura c = event.getRowValue();   // TODO
               // c.getListaPropostas().toString()(event.getNewValue());
            }
        });
        table.getColumns().add(numEstudante);




       observableList = FXCollections.observableList(manager.getArrayCandidaturas());
        table.getItems().addAll(observableList);


        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        getChildren().add(table);

    }



    public void displayTableCandidatura() {

        scene = new Scene(new BorderPane(table), 500, 300);
        stage = new Stage();
        stage.setTitle("Listagem de Candidaturas");
        stage.setScene(scene);
        stage.show();

    }


    public void updateTable(){
        observableList = FXCollections.observableList(manager.getArrayCandidaturas());
        table.getItems().addAll(observableList);


    }



}
