package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;

public interface ApoioPoeIState {

    // interface deve ter poucos metodos e apenas aqueles que representam mudança de estado

    public String filtrarListas(); 

    public boolean alteraModoConfiguracao(int op);

    public boolean voltar();

    public boolean fechaFase();

    public void avanca(); 

    ApoioPoeState getState();

  

}
