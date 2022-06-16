package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public class A_InicioFX extends BorderPane {
    ModelManager manager;

    Button btnIniciar, btnCarregar;

    public A_InicioFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {

        btnIniciar = new Button();
        btnIniciar.setText("Iniciar");
        btnIniciar.setMinWidth(200);
        btnIniciar.setTextFill(Color.GREY);

        btnCarregar = new Button();
        btnCarregar.setText("Carregar estado da Aplicação");
        btnCarregar.setMinWidth(200);
        btnCarregar.setTextFill(Color.ORANGERED);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnIniciar, btnCarregar);
        hbox.setSpacing(100);
        this.setCenter(hbox);
    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });
        btnIniciar.setOnAction(event -> {
            /* ... */ });
        btnCarregar.setOnAction(event -> {
            /* ... */ });

    }

    private void update() {
        if (manager.getState() != ApoioPoeState.INICIO) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }

}
