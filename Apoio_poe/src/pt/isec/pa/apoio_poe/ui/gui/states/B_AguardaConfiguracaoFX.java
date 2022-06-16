package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public class B_AguardaConfiguracaoFX extends BorderPane  {
    ModelManager manager;
    Button btnAlunos, btnDocentes, btnPropostas;
    HBox hbox;

    public B_AguardaConfiguracaoFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {

        // TO DO falta por uma imagem ou assim para ficar + bonitinho 
        btnAlunos = new Button("Alunos");
        btnAlunos.setMinSize(200, 200);

        btnDocentes = new Button("Docentes");
        btnDocentes.setMinSize(200, 200);

        btnPropostas = new Button("Propoostas");
        btnPropostas.setMinSize(200, 200);


        hbox = new HBox();
        hbox.getChildren().addAll( btnAlunos, btnDocentes , btnPropostas);
        hbox.setSpacing(100);
        hbox.setAlignment(Pos.CENTER);
        this.setCenter(hbox);



      

    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });
        btnAlunos.setOnAction(event -> {
            manager.avancaParaAlunos();
        });
        btnDocentes.setOnAction(event -> {
            manager.avancaParaDocentes();
        });
        btnPropostas.setOnAction(event -> {
            manager.avancaParaPropostas();
        });
        



    }

    private void update() {
        if (manager.getState() != ApoioPoeState.AGUARDA_CONFIGURACAO) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }
}
