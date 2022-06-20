package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.InputWindow;
import pt.isec.pa.apoio_poe.ui.gui.TableViews.TableViewPropostas;

public class B_ModoPropostasFX extends BorderPane  {
    ModelManager manager;

    Button btnImportar, btnExportar;
    Button btnVoltar, btnAvancar;

    VBox vboxOpcoesProp;
    VBox vboxTable;

    TableViewPropostas table;
    Button btnUpdate;
    

    public B_ModoPropostasFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();


    }

    private void createViews() {
        btnImportar = new Button("Importar Lista de Propostas");
        btnImportar.setMinSize(200,60);

        btnExportar = new Button("Exportar Lista Propostas");
        btnExportar.setMinSize(200,60);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinSize(200,60);

        btnVoltar = new Button("Voltar");
        btnVoltar.setMinSize(200,60);

        btnUpdate= new Button("Update lista");
        btnUpdate.setMinSize(200, 60);

        vboxOpcoesProp = new VBox();
        vboxOpcoesProp.getChildren().addAll( btnImportar, btnExportar, btnAvancar, btnVoltar, btnUpdate);
        vboxOpcoesProp.setSpacing(10);
        vboxOpcoesProp.setAlignment(Pos.CENTER_RIGHT);
        this.setRight(vboxOpcoesProp);
        vboxOpcoesProp.setPadding(new Insets(40));

        if (manager.getSituacaoEstado() == false ) {
            table = new TableViewPropostas(manager, false);
            btnImportar.setDisable(true);
            btnVoltar.setDisable(true);
        }else {
        table = new TableViewPropostas(manager, true);
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
            String str = InputWindow.display("Importar Lista de Propostas", "Insira o nome do ficheiro a importar: ");
            System.out.println("nome do ficheiro importar " + str ) ;
           manager.importaCVS(str);
         });
 
         btnExportar.setOnAction(event -> {
             String str = InputWindow.display("Exportar Lista de Propostas", "Insira o nome do ficheiro para exportação:  ");
             System.out.println("nome ficheiro exportar " + str ) ;
             manager.exportaCVS(str, manager.listaPropostas()); 
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
        if (manager.getState() != ApoioPoeState.MODO_PROPOSTAS) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }

    
}
