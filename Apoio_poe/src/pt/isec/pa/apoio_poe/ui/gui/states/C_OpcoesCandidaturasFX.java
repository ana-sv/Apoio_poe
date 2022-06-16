package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public class C_OpcoesCandidaturasFX extends BorderPane {
    ModelManager manager;
    HBox hbox;
    Button btnFecharFase;

    public C_OpcoesCandidaturasFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {

        
        btnFecharFase = new Button("Fechar Fase");  // TO DO modificar este botão para ficar difernte dos outros
        btnFecharFase.setMinSize(200, 200);


        hbox = new HBox();
        hbox.getChildren().addAll( btnFecharFase);
        hbox.setSpacing(100);
        hbox.setAlignment(Pos.CENTER);
        this.setCenter(hbox);

    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });
        btnFecharFase.setOnAction(event -> {
            manager.fechaFase();
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
