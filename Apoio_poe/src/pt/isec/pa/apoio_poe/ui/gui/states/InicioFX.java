package pt.isec.pa.apoio_poe.ui.gui.states;

import java.io.File;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.ModelManager;
import pt.isec.pa.apoio_poe.ui.gui.resources.ImageManager;

public class InicioFX extends BorderPane {
    ModelManager manager;

    Button btnIniciar, btnCarregar;

    public InicioFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {

        btnIniciar = new Button();
        btnIniciar.setText("Iniciar");
        btnIniciar.setMinSize(300, 50);

        btnCarregar = new Button();
        btnCarregar.setText("Carregar estado da Aplicação");
        btnCarregar.setMinSize(300, 50);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnIniciar, btnCarregar);
        hbox.setSpacing(50);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(200));
       
        this.setBottom(hbox);


        HBox hboxImagem = new HBox();
        hboxImagem.setBackground(new Background(new BackgroundImage( ImageManager.getImage("logo_isec.png"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null))); 
        this.setCenter(hboxImagem);
        hboxImagem.autosize();
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
                System.err.println("Carregar: " + e);
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
