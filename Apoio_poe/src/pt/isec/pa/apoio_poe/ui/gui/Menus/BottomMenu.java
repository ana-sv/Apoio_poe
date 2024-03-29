package pt.isec.pa.apoio_poe.ui.gui.Menus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import pt.isec.pa.apoio_poe.ui.gui.ModelManager;

public class BottomMenu extends HBox{
    ModelManager manager;
    HBox hbox; 
    Label lb;

  

    public BottomMenu(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    void createViews() {
        hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        // TO DO adicionar bordinha e por bonitinho 
        
        lb = new Label( ); 
        this.getChildren().add(lb);
        lb.setPadding(new Insets(20));



    }

    void registerHandlers() {
      manager.addPropertyChangeListener(evt -> { update(); });

    }

    void update() {
        lb.setText("\tEstado : " + manager.getState().toString());

    }



}