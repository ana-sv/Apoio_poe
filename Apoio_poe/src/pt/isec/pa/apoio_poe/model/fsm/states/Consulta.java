package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

 class Consulta extends StateAdapter {
    private Integer index = 4;



     Consulta(Context context, Data data) {
        super(context, data);

    }



    @Override
    public State getState() {
        return State.CONSULTA;
    }




    public String mostraListas() {
        StringBuilder s = new StringBuilder();

        s.append(data.infoCandidaturasToString(true));

    return s.toString();
    }



    @Override
    public boolean getSituacaoEstado(){
        return data.getSituacaoEstados(this.index);
    }





 
}
