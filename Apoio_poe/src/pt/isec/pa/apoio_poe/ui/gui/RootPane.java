package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.ui.gui.Menus.BottomMenu;
import pt.isec.pa.apoio_poe.ui.gui.Menus.TopMenu;
import pt.isec.pa.apoio_poe.ui.gui.states.InicioFX;
import pt.isec.pa.apoio_poe.ui.gui.states.AtribuicaoOrientadores;
import pt.isec.pa.apoio_poe.ui.gui.states.AtribuicaoPropostas;
import pt.isec.pa.apoio_poe.ui.gui.states.Consulta;
import pt.isec.pa.apoio_poe.ui.gui.states.AguardaConfiguracaoFX;
import pt.isec.pa.apoio_poe.ui.gui.states.ModoAlunosFX;
import pt.isec.pa.apoio_poe.ui.gui.states.ModoDocentesFX;
import pt.isec.pa.apoio_poe.ui.gui.states.ModoPropostasFX;
import pt.isec.pa.apoio_poe.ui.gui.states.OpcoesCandidaturasFX;

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
            new InicioFX( manager ),
            new AguardaConfiguracaoFX( manager ),
            new ModoAlunosFX( manager),
            new ModoDocentesFX( manager),
             new ModoPropostasFX( manager ),
         new OpcoesCandidaturasFX( manager ),
         new AtribuicaoPropostas(manager),
         new AtribuicaoOrientadores(manager),
         new Consulta(manager)



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
