package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.ui.gui.states.*;

public class RootPane extends BorderPane {
    ModelManager manager;

    public RootPane(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        StackPane stackPane = new StackPane(
            new A_InicioFX(manager),
            new B_AguardaConfiguracaoFX(manager)
            // preencher com o restantes estados
        );

        this.setCenter(stackPane);



    }

    private void registerHandlers() {
    }

    private void update() {
    }
}
