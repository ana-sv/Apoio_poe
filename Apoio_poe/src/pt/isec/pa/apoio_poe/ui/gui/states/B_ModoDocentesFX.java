package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.InputWindow;
import pt.isec.pa.apoio_poe.ui.gui.TableViews.TableViewDocentes;

public class B_ModoDocentesFX extends BorderPane {
    ModelManager manager;

    Button btnImportar, btnExportar;
    Button btnVoltar, btnAvancar;

    VBox vboxOpcoesDocentes;
    VBox vboxTable;

    TableViewDocentes table;
    Button btnUpdate;
    

    public B_ModoDocentesFX(ModelManager manager) {
        this.manager = manager;

        createViews(new VBox());
        registerHandlers();
        update();


    }

    private void createViews(VBox box) {
        btnImportar = new Button("Importar Lista de Docentes");
        btnImportar.setMinSize(200,60);

        btnExportar = new Button("Exportar Lista Docentes");
        btnExportar.setMinSize(200,60);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinSize(200,60);

        btnVoltar = new Button("Voltar");
        btnVoltar.setMinSize(200,60);

        btnUpdate= new Button("Update");
        btnUpdate.setMinSize(200, 60);


        vboxOpcoesDocentes = new VBox();
        vboxOpcoesDocentes.getChildren().addAll( btnImportar, btnExportar, btnAvancar, btnVoltar, btnUpdate);
        vboxOpcoesDocentes.setSpacing(10);
        vboxOpcoesDocentes.setAlignment(Pos.CENTER_RIGHT);
        this.setRight(vboxOpcoesDocentes);
        vboxOpcoesDocentes.setPadding(new Insets(40));


        if (manager.getSituacaoEstado() == false) {
            table = new TableViewDocentes(manager, false);
            btnImportar.setDisable(true);
            btnVoltar.setDisable(true);
        }else {
        table = new TableViewDocentes(manager, true);
        }

        vboxTable = new VBox();
        vboxTable.getChildren().addAll(table);
        vboxTable.setAlignment(Pos.CENTER);
        this.setCenter(vboxTable);
        vboxTable.setPadding(new Insets(40));


    }

    private void registerHandlers(){
        manager.addPropertyChangeListener(evt -> {
            update();
        });

        btnImportar.setOnAction(event -> {
            String str = InputWindow.display("Importar Lista de Docentes", "Insira o nome do ficheiro a importar: ");
            System.out.println("nome do ficheiro importar " + str ) ;
           manager.importaCVS(str);
         });
 
         btnExportar.setOnAction(event -> {
             String str = InputWindow.display("Exportar Lista de Docentes", "Insira o nome do ficheiro para exportação:  ");
             System.out.println("nome ficheiro exportar " + str ) ;
             manager.exportaCVS(str, manager.listaDocentes()); 
          });

          btnAvancar.setOnAction(event -> {
            manager.avancaEstado();
          });

          btnVoltar.setOnAction(event -> {
            manager.volta(); 
          });

          btnUpdate.setOnAction(event -> {
            table.updateTable();
       });

 
    }

    private void update(){
        if (manager.getState() != ApoioPoeState.MODO_DOCENTES) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }

    
}
