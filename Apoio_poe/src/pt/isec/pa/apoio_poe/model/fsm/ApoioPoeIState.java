package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;



public interface ApoioPoeIState {

    // interface deve ter poucos metodos e apenas aqueles que representam mudança de estado

    public String importaCVS( String nomeFicheiro );
    public String exportaCVS( String nomeFicheiro, String lista );

    public String gravaEstadoApp ( Data data , String nomeFicheiro );
    public Data carregaEstadoApp( String nomeFicheiro ); 

    public void alteraModoConfiguracao(int op);

    public boolean voltar();

    public boolean fechaEstado();

    public void avancaEstado(); 

    public boolean getSituacaoEstado();

    ApoioPoeState getState();


  

}
