package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.fsm.states.ApoioPoeState;



public interface ApoioPoeIState {

    // interface deve ter poucos metodos e apenas aqueles que representam mudança de estado

    public String importaCVS( String nomeFicheiro );
    public String exportaCVS( String nomeFicheiro );

    public String gravaEstadoApp ( ApoioPoeContext contexto , String nomeFicheiro );
    public ApoioPoeContext carregaEstadoApp( String nomeFicheiro ); 

    public boolean alteraModoConfiguracao(int op);

    public boolean voltar();

    public boolean fechaEstado();

    public void avancaEstado(); 

    public boolean getSituacaoEstado();

    ApoioPoeState getState();


  

}
