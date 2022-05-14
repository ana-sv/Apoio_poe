
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
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeIState.Fase;

public class ApoioPoeContext implements Serializable {
    private ApoioPoeIState state;
    private ApoioPoeData data;

    public ApoioPoeContext() {
        data = new ApoioPoeData();
        state = ApoioPoeState.AGUARDA_CONFIGURACAO.createState(this, data);
        // referencia para o estado atual que poderá ser iniciado no seu construtor
    }

    // Método package-private que permita alterar o estado atual
    void changeState(ApoioPoeIState newState) {
        state = newState;
    }

    public String mostraListas() {
        return state.mostraListas();
    }

    // Método público que permita obter o estado atual
    public ApoioPoeState getState() {
        if (state == null)
            return null;

        return state.getState();
    }

    public Fase getFaseEnum() {
        return state.getFase();
    }

    public String getFase() {
        return state.getFase().toString();
    }

    // Métodos que reencaminhem as ações/eventos para o estado ativo

    public boolean alteraModoConfiguracao(int op) {
        return state.alteraModoConfiguracao(op);
    }

    public void avanca() {
        state.avanca();
    }

    public boolean avancaFechandoFase() {
        return state.fechaFase();
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

    public String filtraListas(String filtros) {
        // return state.filtraListas();
        return "NAO IMPLEMENTADO";
    }

    public String gravaEstadoAplicacao(String nomeFicheiro) {
        return state.gravaEstadoApp(this, nomeFicheiro);
    }

    public String carregaEstadoAplicacao(String nomeFicheiro) { // MELHORAR
        ApoioPoeContext a = new ApoioPoeContext();
        a = state.carregaEstadoApp(nomeFicheiro);

        if (a != null) {
            this.data = a.data;
            this.state = a.state;
            return "\n> Estado Carregado com sucesso!\n";
        }

        return "\n> Falhou carregamento do estado da aplicacao!\n";
    }



    // Conjunto de métodos que permita obter os dados necessários à
    // interação com o utilizador ou com os restantes módulos do programa

}
