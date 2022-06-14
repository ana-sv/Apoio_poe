
/**
*
*  @author AnaVideira 
*
*  Classe que comunica com a user interface
*
*/

package pt.isec.pa.apoio_poe.model.fsm;

import java.io.Serializable;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.states.State;

public class Context implements Serializable {
    private IState state;
    private ApoioPoeData data;

    public Context() {
        data = new ApoioPoeData();
        state = State.AGUARDA_CONFIGURACAO.createState(this, data);
        // referencia para o estado atual que poderá ser iniciado no seu construtor
    }

    // Método package-private que permita alterar o estado atual
    void changeState(IState newState) {
        state = newState;
    }


    // Método público que permita obter o estado atual
    public State getState() {
        if (state == null)
            return null;

        return state.getState();
    }




    // Métodos que reencaminhem as ações/eventos para o estado ativo

    public boolean alteraModoConfiguracao(int op) {
        return state.alteraModoConfiguracao(op);
    }

    public void avanca() {
        state.avancaEstado();
    }

    public boolean avancaFechandoFase() {
        return state.fechaEstado();
    }

    public boolean volta() {
        return state.voltar();
    }

    public String importaCVS(String nomeFicheiro) {
        return state.importaCVS(nomeFicheiro);
    }

    public String exportaCVS(String nomeFicheiro) {
        return state.exportaCVS(nomeFicheiro);
    }


    public String gravaEstadoAplicacao(String nomeFicheiro) {
        return state.gravaEstadoApp(this.data, nomeFicheiro);
    }

    public String carregaEstadoAplicacao(String nomeFicheiro) { // MELHORAR
        ApoioPoeData a = new ApoioPoeData();
        a = state.carregaEstadoApp(nomeFicheiro);

        if (a!= null) {
            this.data = a;
            return "\n> Estado Carregado com sucesso!\n";
        }

        return "\n> Falhou carregamento do estado da aplicacao!\n";
    }



    // Conjunto de métodos que permita obter os dados necessários à
    // interação com o utilizador ou com os restantes módulos do programa


    public Boolean getSituacaoEstado(){
        return state.getSituacaoEstado();
    }

    public String mostraListas() {
        return  data.mostraListas();
    }

    
    public String filtraListas(String filtros) {
        // return filtraListas();
        return "NAO IMPLEMENTADO";
    }




}
