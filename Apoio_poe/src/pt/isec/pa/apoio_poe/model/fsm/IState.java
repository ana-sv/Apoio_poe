package pt.isec.pa.apoio_poe.model.fsm;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.states.State;



public interface IState {

    // interface deve ter poucos metodos e apenas aqueles que representam mudança de estado

    public String importaCVS( String nomeFicheiro );
    public String exportaCVS( String nomeFicheiro );

    public String gravaEstadoApp ( Data data , String nomeFicheiro );
    public Data carregaEstadoApp( String nomeFicheiro ); 

    public boolean alteraModoConfiguracao(int op);

    public boolean voltar();

    public boolean fechaEstado();

    public void avancaEstado(); 

    public boolean getSituacaoEstado();

    State getState();


  

}
