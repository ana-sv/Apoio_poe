package pt.isec.pa.apoio_poe.ui.gui.states;

import java.io.File;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
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
        btnIniciar.setMinSize(250, 50);

        btnCarregar = new Button();
        btnCarregar.setText("Carregar estado da Aplicação");
        btnCarregar.setMinSize(250, 50);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnIniciar, btnCarregar);
        hbox.setSpacing(200);
        hbox.setAlignment(Pos.CENTER);
        this.setCenter(hbox);
    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });
        btnIniciar.setOnAction(event -> {
            manager.avancaEstado();
        });
        btnCarregar.setOnAction(event -> {
            FileChooser fChooser = new FileChooser();
            File f = fChooser.showOpenDialog(null);

            if (f == null)
                return;

            try {
                manager.carregaEstadoAplicacao(f.getCanonicalPath());
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Save: " + e);
            }
        });

    }

    private void update() {
        if (manager.getState() != ApoioPoeState.INICIO) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }

}
