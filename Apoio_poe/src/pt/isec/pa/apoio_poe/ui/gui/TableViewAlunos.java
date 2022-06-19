package pt.isec.pa.apoio_poe.ui.gui;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import pt.isec.pa.apoio_poe.model.data.Aluno;

public class TableViewAlunos extends VBox  {   

    private TableView<Aluno> table;
    private TableColumn<Aluno, Long> numEstudante;
    private TableColumn<Aluno, String> nome; 
    private TableColumn<Aluno, String> mail; 
    private TableColumn<Aluno, String> siglaCurso;
    private TableColumn<Aluno, String> SiglaRame;
    private TableColumn<Aluno, Double> classificacao;
    private TableColumn<Aluno,Boolean> estagioAcesso; 



    public TableViewAlunos() {

        table = new TableView<Aluno>();
        table.setEditable(true);



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
		nome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("Nome"));
		nome.setCellFactory(TextFieldTableCell.forTableColumn());
		nome.setOnEditCommit(new EventHandler<CellEditEvent<Aluno, String>>() {
			@Override
			public void handle(CellEditEvent<Aluno, String> event) {
				Aluno aluno = event.getRowValue();
				aluno.setNome(event.getNewValue());
			}
		});
        table.getColumns().add(nome);

















        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        getChildren().add(table);





    }

    public void add( Aluno aluno){
        table.getItems().add(aluno);
    }


    

   
}



