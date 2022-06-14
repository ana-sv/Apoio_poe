package pt.isec.pa.apoio_poe.model.fsm.states;
import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;

 class OpcoesCandidaturas extends StateAdapter {
    private Integer index = 1;


     OpcoesCandidaturas(Context context, Data data) {
        super(context, data);
    }



    public String filtraListasAlunos( Integer q , String filtros ) {  //autoproposta , registada , nao registada
        // TO DO
        return " ";
    }




    public String filtraListasPropostas( Integer q ,String filtros ) { // autopropostas, docentes, com candidatura , sem candidatura
        // TO DO
        return " ";
    }

    public String mostraListas() {
        StringBuilder s = new StringBuilder();

        s.append("\nCANDIDATURAS");

        for( Candidatura c : data.getListaCandidaturas().values() )
            s.append( c.candidaturaToString() );

        return s.toString();
    }


    @Override
    public String importaCVS(String nomeFicheiro) {
        return Ficheiro.importaCVScandidaturas(nomeFicheiro, this.data);

    }



    @Override
    public State getState() {
        return State.OPCOES_CANDIDATURAS;
    }



    @Override
    public boolean voltar(){ 
        if (data.getSituacaoEstados(this.index) == true) {
            changeState( State.AGUARDA_CONFIGURACAO );
            return true;
        }
        return false; 
    }


    @Override
    public void avancaEstado() {
        changeState( State.ATRIBUICAO_PROPOSTAS );
  
    }

    @Override
    public boolean fechaEstado() {
        // TODO : impedir fechar se houverem candidaturas sem proposta 

        data.setSituacaoEstados( this.index, false);
        return true;    
    }



    @Override
    public boolean getSituacaoEstado(){
        return data.getSituacaoEstados(this.index);
    }




    
    
}
