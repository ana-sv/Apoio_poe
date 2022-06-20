package pt.isec.pa.apoio_poe.ui.gui.states;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.InputWindow;

public class Consulta extends BorderPane {
    ModelManager manager;

    Button  btnExportar ,  btnExportarFiltrado;

    VBox vboxOpcoes;

    public Consulta(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {


        btnExportar = new Button("Exportar Lista Alunos");
        btnExportar.setMinSize(200, 60);

        vboxOpcoes = new VBox();
        vboxOpcoes.getChildren().addAll(btnExportar);
        this.setRight(vboxOpcoes);
        vboxOpcoes.setPadding(new Insets(40));
        vboxOpcoes.setSpacing(20);
        vboxOpcoes.setAlignment(Pos.CENTER);


    }

    private void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });

        btnExportar.setOnAction(event -> {
            String str = InputWindow.display("Exportar Lista de Alunos",
                    "Insira o nome do ficheiro para exportação:  ");
            System.out.println("nome ficheiro exportar " + str);
            manager.exportaCVS(str, manager.listaAlunos());
            // TODO exportar listas finais em vez desta
        });
   
        

    }

    private void update() {
        if (manager.getState() != ApoioPoeState.CONSULTA) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

    }

}