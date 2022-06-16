package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.ui.gui.states.A_InicioFX;
import pt.isec.pa.apoio_poe.ui.gui.states.B_AguardaConfiguracaoFX;
import pt.isec.pa.apoio_poe.ui.gui.states.B_ModoAlunosFX;

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
            new B_AguardaConfiguracaoFX( manager ),
            new B_ModoAlunosFX(manager)
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
