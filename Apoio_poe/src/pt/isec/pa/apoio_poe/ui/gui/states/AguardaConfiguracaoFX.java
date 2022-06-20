package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public class AguardaConfiguracaoFX extends BorderPane  {
    ModelManager manager;
    Button btnAlunos, btnDocentes, btnPropostas;
    Button btnFecharFase,  btnAvancar;
    HBox hbox;

    public AguardaConfiguracaoFX(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {

        // TO DO falta por uma imagem ou assim para ficar + bonitinho 
        btnAlunos = new Button("Alunos");
        btnAlunos.setMinSize(100, 150);

        btnDocentes = new Button("Docentes");
        btnDocentes.setMinSize(100, 150);

        btnPropostas = new Button("Propoostas");
        btnPropostas.setMinSize(100, 150);

        btnFecharFase = new Button("Fechar Fase");  // TO DO modificar este botão para ficar difernte dos outros
        btnFecharFase.setMinSize(100, 150);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinSize(100, 150);



        hbox = new HBox();
        hbox.getChildren().addAll( btnAlunos, btnDocentes , btnPropostas, btnFecharFase, btnAvancar);
        hbox.setSpacing(50);
        hbox.setAlignment(Pos.CENTER);
        this.setCenter(hbox);

    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });
        btnAlunos.setOnAction(event -> {
            manager.avancaParaAlunos();
        });
        btnDocentes.setOnAction(event -> {
            manager.avancaParaDocentes();
        });
        btnPropostas.setOnAction(event -> {
            manager.avancaParaPropostas();
        });
        btnFecharFase.setOnAction(event -> {
            manager.fechaFase();
        });

        btnAvancar.setOnAction(event -> {
            manager.avancaEstado();
        });
        



    }

    private void update() {
        if (manager.getState() != ApoioPoeState.AGUARDA_CONFIGURACAO) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }
}
