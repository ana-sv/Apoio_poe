package pt.isec.pa.apoio_poe.ui.gui;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.data.Aluno;

public class TableViewData extends VBox  {   // TO DO  NAO FUNCIONA

 TableView<Aluno> table ;
 ObservableList<Aluno> obList;

    public TableViewData(ArrayList<Aluno> alunosList) {

        table = new TableView<>();    
       
        TableColumn<Aluno, Long> cNumero = new TableColumn<>("Numero Aluno");
        cNumero.setCellValueFactory(new PropertyValueFactory<>("numEstudante"));

        TableColumn<Aluno, String> cNome = new TableColumn<>("Nome");
        cNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        table.setItems(obList);
        table.getColumns().add(cNome);

  

    }


    public ObservableList<Aluno> obAlunos(ArrayList<Aluno> list){

        for(Aluno a : list )
         obList.add( a); 

        return obList;

    }

}



