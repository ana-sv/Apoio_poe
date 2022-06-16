package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.InputWindow;

public class B_ModoPropostasFX extends BorderPane  {
    ModelManager manager;

    Button btnImportar, btnExportar;
    Button btnVoltar, btnAvancar;

    VBox vboxOpcoesDocentes;
    

    public B_ModoPropostasFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();


    }

    private void createViews() {
        btnImportar = new Button("Importar Lista de Propostas");
        btnImportar.setMinSize(150,60);

        btnExportar = new Button("Exportar Lista Propostas");
        btnExportar.setMinSize(150,60);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinSize(150,60);

        btnVoltar = new Button("Voltar");
        btnVoltar.setMinSize(150,60);

        vboxOpcoesDocentes = new VBox();
        vboxOpcoesDocentes.getChildren().addAll( btnImportar, btnExportar, btnAvancar, btnVoltar);
        vboxOpcoesDocentes.setSpacing(10);
        vboxOpcoesDocentes.setAlignment(Pos.CENTER_RIGHT);
        this.setCenter(vboxOpcoesDocentes);


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
 
    }

    private void update(){
        if (manager.getState() != ApoioPoeState.MODO_PROPOSTAS) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }

    
}
