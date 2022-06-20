package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.InputWindow;
import pt.isec.pa.apoio_poe.ui.gui.ModelManager;

public class OpcoesCandidaturasFX extends BorderPane {
    ModelManager manager;

    Button btnImportar, btnExportar;
    Button btnVoltar, btnAvancar, btnFecharFase;


    VBox vboxOpcoesCandidaturas;
   

    public OpcoesCandidaturasFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

        btnImportar = new Button("Importar Lista Candidaturas");
        btnImportar.setMinSize(200,60);

        btnExportar = new Button("Exportar Lista Candidaturas");
        btnExportar.setMinSize(200,60);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinSize(200,60);

        btnVoltar = new Button("Voltar");
        btnVoltar.setMinSize(200,60);
        
        btnFecharFase = new Button("Fechar Fase");  // TO DO modificar este botão para ficar difernte dos outros
        btnFecharFase.setMinSize(200, 200);


        vboxOpcoesCandidaturas = new VBox();
        vboxOpcoesCandidaturas.getChildren().addAll( btnImportar, btnExportar, btnAvancar, btnVoltar );
        vboxOpcoesCandidaturas.setSpacing(10);
        vboxOpcoesCandidaturas.setAlignment(Pos.CENTER_RIGHT);
        this.setRight(vboxOpcoesCandidaturas);
        vboxOpcoesCandidaturas.setPadding( new Insets(40));
        

    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });


        btnImportar.setOnAction(event -> {
            String str = InputWindow.display("Importar Lista de Candidaturas", "Insira o nome do ficheiro a importar: ");
            System.out.println("nome do ficheiro importar " + str ) ;
           manager.importaCVS(str);
         });
 
         btnExportar.setOnAction(event -> {
             String str = InputWindow.display("Ixportar Lista de Candidaturas", "Insira o nome do ficheiro para exportação:  ");
             System.out.println("nome ficheiro exportar " + str ) ;
             manager.exportaCVS(str, manager.listaCandidaturas()); 
          });
        btnFecharFase.setOnAction(event -> {
            manager.fechaFase();
        });

        btnAvancar.setOnAction(event -> {
            manager.avancaEstado();
         });
         btnVoltar.setOnAction(event -> {
             manager.volta();
         });
        
    }

    private void update() {
        if (manager.getState() != ApoioPoeState.OPCOES_CANDIDATURAS) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }

}
