package pt.isec.pa.apoio_poe.ui.gui.Menus;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import pt.isec.pa.apoio_poe.model.ModelManager;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.ui.gui.TableViews.TableViewAlunos;
import pt.isec.pa.apoio_poe.ui.gui.TableViews.TableViewCandidaturas;
import pt.isec.pa.apoio_poe.ui.gui.TableViews.TableViewDocentes;
import pt.isec.pa.apoio_poe.ui.gui.TableViews.TableViewPropostas;

public class TopMenu extends MenuBar {
    ModelManager manager;

    Menu menuAplicacao;
    MenuItem gravar, carregar;

    Menu menuOpcoes;
    MenuItem undo, redo;

    Menu menuListas;
    MenuItem listaAlunos, listaDocentes, listaPropostas, listaCandidaturas, listaFiltrada;

           
    TableViewAlunos table;
    TableViewDocentes tableDocentes;
    TableViewPropostas tablePropostas;
    TableViewCandidaturas tableCandidaturas;

    public TopMenu(ModelManager manager) {
        this.manager = manager;

        createViews();
        registerHandlers();
        update();

    }

    void createViews() {

        menuAplicacao = new Menu("Aplicação");
        gravar = new MenuItem("Gravar");
        carregar = new MenuItem("Carregar");

        menuAplicacao.getItems().setAll(carregar, new SeparatorMenuItem(), gravar);
        this.getMenus().add(menuAplicacao);

        menuOpcoes = new Menu("Opções");
        undo = new MenuItem("Undo");
        redo = new MenuItem("Redo");
        menuOpcoes.getItems().setAll(undo, new SeparatorMenuItem(), redo);
        this.getMenus().add(menuOpcoes);

        menuListas = new Menu("Listas");
        listaAlunos = new MenuItem("Listagem Alunos");
        listaDocentes = new MenuItem("Listagem Docentes");
        listaPropostas = new MenuItem("Listagem Propostas");
        listaCandidaturas = new MenuItem("Listagem Candidaturas");
        listaFiltrada = new MenuItem("Listagem Filtrada");
        menuListas.getItems().setAll(listaAlunos, new SeparatorMenuItem(),
                listaDocentes, new SeparatorMenuItem(),
                listaPropostas, new SeparatorMenuItem(),
                listaCandidaturas, new SeparatorMenuItem(), listaFiltrada);
        this.getMenus().add(menuListas);

      

    }

    void registerHandlers() {
        manager.addPropertyChangeListener(evt -> {
            update();
        });
        gravar.setOnAction(evt -> {

        });
        carregar.setOnAction(evt -> {
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
        listaAlunos.setOnAction(evt -> {

           table = new TableViewAlunos(manager, false);
            this.table.displayTableAlunos();

    
        });

        listaDocentes.setOnAction(evt -> {

            tableDocentes = new TableViewDocentes(manager, false);
             this.tableDocentes.displayTableDocentes();
 
     
         });
         listaPropostas.setOnAction(evt -> {

            tablePropostas = new TableViewPropostas(manager, false);
             this.tablePropostas.displayTablePropostas();
 
     
         });

         listaCandidaturas.setOnAction(evt -> {

            tableCandidaturas = new TableViewCandidaturas(manager, false);
            this.tableCandidaturas.displayTableCandidatura();
      
 
     
         });
     

    }

    private void update() {
        if (manager.getState() == ApoioPoeState.INICIO) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);


        // TO DO , por butoes a funcinoar ou não conforme o estado
        // if (manager.getState() == ApoioPoeState. ) {
    }

}
