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
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.data.Proposta;

public class TableViewPropostas extends VBox {
    ModelManager manager;

    private TableView<Proposta> table;

    private TableColumn<Proposta, String> codigoProp;
    private TableColumn<Proposta, String> tipo; 
    private TableColumn<Proposta, String> titulo;
  //  private TableColumn<Projeto, String> mailDocente; 


    // TODO
  //  private TableColumn<Projeto, String> area; 
   // private TableColumn<Projeto, String> entAcolhimento; 
    //private TableColumn<Proposta, Long> nEstudante; 
   
    


    private Scene scene;
    private Stage stage;

     private  ObservableList<Proposta> observableList ;

    public TableViewPropostas(ModelManager manager, Boolean edit) {
        this.manager = manager;

        table = new TableView<Proposta>();

        table.setEditable(edit);

        
        codigoProp = new TableColumn<Proposta, String>("Código");
        codigoProp.setCellValueFactory(new PropertyValueFactory<Proposta, String>("codigoProp"));
        codigoProp.setCellFactory(TextFieldTableCell.forTableColumn());
        codigoProp.setOnEditCommit(new EventHandler<CellEditEvent<Proposta, String>>() {
            @Override
            public void handle(CellEditEvent<Proposta, String> event) {
               Proposta prop = event.getRowValue();
                prop.setCodigoProp(event.getNewValue());
            }
        });
        table.getColumns().add(codigoProp);


        tipo = new TableColumn<Proposta, String>("Tipo");
        tipo.setCellValueFactory(new PropertyValueFactory<Proposta, String>("tipo"));
        tipo.setCellFactory(TextFieldTableCell.forTableColumn());
        tipo.setOnEditCommit(new EventHandler<CellEditEvent<Proposta, String>>() {
            @Override
            public void handle(CellEditEvent<Proposta, String> event) {
               Proposta prop = event.getRowValue();
                prop.setTipo(event.getNewValue());
            }
        });
        table.getColumns().add(tipo);

        titulo = new TableColumn<Proposta, String>("Titulo");
        titulo.setCellValueFactory(new PropertyValueFactory<Proposta, String>("titulo"));
        titulo.setCellFactory(TextFieldTableCell.forTableColumn());
        titulo.setOnEditCommit(new EventHandler<CellEditEvent<Proposta, String>>() {
            @Override
            public void handle(CellEditEvent<Proposta, String> event) {
             //  Proposta prop = event.getRowValue();
              // prop.setTitulo(event.getNewValue());  //TODO
            }
        });
        table.getColumns().add(titulo);

/*
        mailDocente = new TableColumn<Projeto, String>("Orientador");
        mailDocente.setCellValueFactory(new PropertyValueFactory<Projeto, String>("mailDocente"));
        mailDocente.setCellFactory(TextFieldTableCell.forTableColumn());
        mailDocente.setOnEditCommit(new EventHandler<CellEditEvent< Projeto, String>>() {
            @Override
            public void handle(CellEditEvent<Projeto, String> event) {
                Projeto prop = event.getRowValue();
               prop.setMailOrientador(event.getNewValue());
            }
        });
        table.getColumns().add(mailDocente);
        */

        

      

       observableList = FXCollections.observableList(manager.getArrayPropostas());
        table.getItems().addAll(observableList);



        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        getChildren().add(table);

    }



    public void displayTablePropostas() {

        scene = new Scene(new BorderPane(table));
        stage = new Stage();
        stage.setTitle("Listagem de Propostas");
        stage.setScene(scene);
        stage.show();

    }


    public void updateTable(){
        observableList = FXCollections.observableList(manager.getArrayPropostas());
        table.getItems().addAll(observableList);


    }



}
