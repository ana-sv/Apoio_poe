package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.ui.gui.states.A_InicioFX;
import pt.isec.pa.apoio_poe.ui.gui.states.B_AguardaConfiguracaoFX;
import pt.isec.pa.apoio_poe.ui.gui.states.B_ModoAlunosFX;
import pt.isec.pa.apoio_poe.ui.gui.states.B_ModoDocentesFX;
import pt.isec.pa.apoio_poe.ui.gui.states.B_ModoPropostasFX;
import pt.isec.pa.apoio_poe.ui.gui.states.C_OpcoesCandidaturasFX;

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
            new B_ModoAlunosFX( manager),
            new B_ModoDocentesFX( manager),
             new B_ModoPropostasFX( manager ),
         new C_OpcoesCandidaturasFX( manager )



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
