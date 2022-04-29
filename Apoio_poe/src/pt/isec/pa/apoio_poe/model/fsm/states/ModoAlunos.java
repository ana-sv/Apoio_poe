package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class ModoAlunos extends ApoioPoeStateAdapter{

    ModoAlunos(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.MODO_ALUNOS;
    }

    // TO DO 
    // importar
    // exportar 

    // APENAS NA META 2 
    // inserir 
    // remover 
    // editar 

    @Override
    public String filtrarListas() {
        // TODO
        return super.filtrarListas();
    }

    @Override
    public void avanca() {
        changeState(ApoioPoeState.AGUARDA_CONFIGURACAO);
    }




    
}
