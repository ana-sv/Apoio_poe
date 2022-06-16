package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        // TO DO aplicar CSS aqui 
        StackPane stackPane = new StackPane(
            new A_InicioFX( manager ),
            new B_AguardaConfiguracaoFX( manager )
            // preencher com o restantes estados
        );

        this.setCenter(stackPane);
        this.setTop( new TopMenu( manager ));
        this.setBottom( new BottomMenu( manager ));

    }

    private void registerHandlers() {
    }

    private void update() {
    }
}
