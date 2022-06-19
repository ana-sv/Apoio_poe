package pt.isec.pa.apoio_poe.ui.gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.ui.gui.resources.ImageManager;


public class MainJFX extends Application {
    ModelManager modelManager;
    
    @Override
    public void init() throws Exception {
        super.init();
        modelManager = new ModelManager(); // here or in the constructor
    }

  @Override
    public void start(Stage primaryStage) throws Exception {

        RootPane root = new RootPane(modelManager);
        Scene scene = new Scene(root,700,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle(" Gestão de Projetos e Estágios ");
        primaryStage.getIcons().add(ImageManager.getImage("politecnico_icon.png") );
        primaryStage.setMinWidth(1200);   
        primaryStage.setMinHeight(800);
        primaryStage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }

  

}
