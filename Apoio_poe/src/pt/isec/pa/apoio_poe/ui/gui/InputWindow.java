package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InputWindow {

    private InputWindow(){
    }
    

    public static String display(String title, String headerText) {

        Stage w = new Stage();
        w.initModality(Modality.APPLICATION_MODAL);
        w.setTitle(title);
        w.setMinWidth(250);

        TextInputDialog dialog  = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);

      return  dialog.showAndWait().get();
        
    }

}
