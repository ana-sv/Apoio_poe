package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;

class ModoDocentes extends ApoioPoeStateAdapter {

     ModoDocentes(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }



    @Override
    public String mostraListas() {
        StringBuilder str= new StringBuilder();
        for ( Docente a : data.getListaDocentes().values()) {
            str.append(a.DocentesToString());
        }
        if(str.isEmpty())
            str.append("\n> SEM IMFORMACAO !");

        return str.toString();
    }



    @Override
    public String importaCVS(String nomeFicheiro) {
        return Ficheiro.importaCVSdocentes(nomeFicheiro, this.data);
    }


    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.MODO_DOCENTES;
    }


    @Override
    public void avanca() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }




    
}
