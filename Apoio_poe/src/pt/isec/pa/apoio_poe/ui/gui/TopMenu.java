package pt.isec.pa.apoio_poe.ui.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import pt.isec.pa.apoio_poe.model.ModelManager;

public class TopMenu extends MenuBar {
    ModelManager manager;

    Menu menuAplicacao;
    MenuItem gravar, carregar;

    Menu menuOpcoes;
    MenuItem undo, redo;

    Menu menuListas;
    MenuItem listaAlunos, listaDocentes, listaPropostas, listaCandidaturas, listaFiltrada;

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

    }

    void update() {

    }



}
