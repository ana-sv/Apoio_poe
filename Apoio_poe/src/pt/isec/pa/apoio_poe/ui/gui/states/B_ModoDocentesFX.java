package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.scene.layout.BorderPane;
import pt.isec.pa.apoio_poe.model.ModelManager;

public class B_ModoDocentesFX extends BorderPane {
    ModelManager manager;
    

    public B_ModoDocentesFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();


    }

    private void createViews() {}
    private void registerHandlers(){}
    private void update(){}

    
}
