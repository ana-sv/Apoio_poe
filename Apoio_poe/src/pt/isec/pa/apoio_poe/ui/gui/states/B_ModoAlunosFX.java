package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public class B_ModoAlunosFX extends BorderPane  {
    ModelManager manager;


    public B_ModoAlunosFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {



    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });


    }

    private void update() {
        if (manager.getState() != ApoioPoeState.MODO_ALUNOS) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }
}
 