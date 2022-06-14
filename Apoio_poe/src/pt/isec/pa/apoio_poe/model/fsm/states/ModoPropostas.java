package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.data.Proposta;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;

class ModoPropostas extends StateAdapter{

     ModoPropostas(Context context, Data data) {
        super(context, data);
    }

    
    


    public String mostraListas() {
        StringBuilder str= new StringBuilder();
        for ( Proposta a : data.getListaProposta().values()) {
            str.append(a.propostasToString());
        }

        
        if(str.isEmpty())
            str.append("\n> SEM IMFORMACAO !");

        return str.toString();
    }


    @Override
    public String importaCVS(String nomeFicheiro) {
        return Ficheiro.importaCVSpropostas(nomeFicheiro, this.data);
    }

    @Override
    public State getState() {
        return State.MODO_PROPOSTAS;
    }

    @Override
    public void avancaEstado() {
        changeState(State.AGUARDA_CONFIGURACAO);
    }
    



}
