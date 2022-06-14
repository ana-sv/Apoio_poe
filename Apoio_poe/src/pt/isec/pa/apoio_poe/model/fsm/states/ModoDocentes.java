package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;

class ModoDocentes extends StateAdapter {

     ModoDocentes(Context context, Data data) {
        super(context, data);
    }




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
    public State getState() {
        return State.MODO_DOCENTES;
    }


    @Override
    public void avancaEstado() {
        changeState(State.AGUARDA_CONFIGURACAO);
    }




    
}
