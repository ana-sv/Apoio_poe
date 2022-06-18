package pt.isec.pa.apoio_poe.ui.gui;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
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



