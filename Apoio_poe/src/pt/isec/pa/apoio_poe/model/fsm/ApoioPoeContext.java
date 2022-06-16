
/**
*
*  @author AnaVideira 
*
*  Classe que comunica com a user interface
*
*/

package pt.isec.pa.apoio_poe.model.fsm;

import java.io.Serializable;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public class ApoioPoeContext implements Serializable {
    private ApoioPoeIState state;
    private Data data;

    public ApoioPoeContext() {
        data = new Data();
        state = ApoioPoeState.INICIO.createState(this, data);
        // referencia para o estado atual que poderá ser iniciado no seu construtor
    }

    // Método package-private que permita alterar o estado atual
    void changeState(ApoioPoeIState newState) {
        state = newState;
    }


    // Método público que permita obter o estado atual
    public ApoioPoeState getState() {
        if (state == null)
            return null;

        return state.getState();
    }




    // Métodos que reencaminhem as ações/eventos para o estado ativo

    public void alteraModoConfiguracao(int op) {
        state.alteraModoConfiguracao(op);
    }

    public void avancaParaAlunos(){
        state.alteraModoConfiguracao(1);
    }

    public void avancaParaDocentes(){
        state.alteraModoConfiguracao(2);
    }

    public void avancaParaPropostas(){
        state.alteraModoConfiguracao(3);
    }



    public void avancaEstado() {
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

    public String exportaCVS(String nomeFicheiro, String lista) {
        return state.exportaCVS(nomeFicheiro, lista);
    }


    public String gravaEstadoAplicacao(String nomeFicheiro) {
        return state.gravaEstadoApp(this.data, nomeFicheiro);
    }

    public String carregaEstadoAplicacao(String nomeFicheiro) { // MELHORAR
        Data a = new Data();
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

    public String mostraListaAlunos(){
        return data.mostraListasAlunos();
    }

    public String mostraListaDocentes(){
        return data.mostraListasAlunos();
    }

    public String mostraListaPropostas(){
        return data.mostraListaPropostas();
    }

    
    public String mostraListaCandidaturas(){
        return data.mostraListaCandidaturas();
    }
    
    public String filtraListas(String filtros) {
        // return filtraListas();
        return "NAO IMPLEMENTADO";
    }




}
