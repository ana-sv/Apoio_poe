package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class Consulta extends ApoioPoeStateAdapter {
    private Integer index = 4;



     Consulta(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);

    }



    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.CONSULTA;
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
