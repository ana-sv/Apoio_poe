package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;

class ModoAlunos extends StateAdapter{

    ModoAlunos(Context context, ApoioPoeData data) {
        super(context, data);
    }


  
    public String mostraListas() {
        StringBuilder str= new StringBuilder();
        for ( Aluno a : data.getListaAlunos().values()) {
            str.append(a.alunoToString());
        }

        if(str.isEmpty())
            str.append("\n> SEM IMFORMACAO !");

        return str.toString();
    }


    
    
    @Override
    public String importaCVS(String nomeFicheiro) { 
        return Ficheiro.importaCVSalunos(nomeFicheiro,this.data);
    }

    

    @Override
    public State getState() {
        return State.MODO_ALUNOS;
    }


    @Override
    public void avancaEstado() {
        changeState(State.AGUARDA_CONFIGURACAO);
    }

    



    
}
