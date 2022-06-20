package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class ModoAlunos extends StateAdapter{

    ModoAlunos(ApoioPoeContext context, Data data) {
        super(context, data);
    }
    
    
    @Override
    public String importaCVS(String nomeFicheiro) { 
        return Ficheiro.importaCVSalunos(nomeFicheiro,this.data);
    }

    

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.MODO_ALUNOS;
    }


    @Override
    public void avancaEstado() {
        changeState(ApoioPoeState.OPCOES_CANDIDATURAS);
    }



    @Override
    public boolean voltar() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
        return true;
    }


    
}
