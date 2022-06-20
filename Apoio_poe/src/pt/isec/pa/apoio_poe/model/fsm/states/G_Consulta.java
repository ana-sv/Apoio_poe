package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

 class G_Consulta extends StateAdapter {
    private Integer index = 4;



     G_Consulta(ApoioPoeContext context, Data data) {
        super(context, data);

    }



    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.CONSULTA;
    }




    @Override
    public boolean getSituacaoEstado(){
        return data.getSituacaoEstados(this.index);
    }





 
}
