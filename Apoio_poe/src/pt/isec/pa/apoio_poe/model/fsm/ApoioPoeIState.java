package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;



public interface ApoioPoeIState {

    // interface deve ter poucos metodos e apenas aqueles que representam mudança de estado

    public String importaCVS( String nomeFicheiro );
    public String exportaCVS( String nomeFicheiro );

    public String gravaEstadoApp ( ApoioPoeData data , String nomeFicheiro );
    public ApoioPoeData carregaEstadoApp( String nomeFicheiro ); 

    public boolean alteraModoConfiguracao(int op);

    public boolean voltar();

    public boolean fechaEstado();

    public void avancaEstado(); 

    public boolean getSituacaoEstado();

    ApoioPoeState getState();


  

}
