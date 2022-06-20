package pt.isec.pa.apoio_poe.model.fsm.states;
import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;
import pt.isec.pa.apoio_poe.model.fsm.Ficheiro;

 class C_OpcoesCandidaturas extends StateAdapter {
    private Integer id = 1;


     C_OpcoesCandidaturas(ApoioPoeContext context, Data data) {
        super(context, data);
    }


    @Override
    public String importaCVS(String nomeFicheiro) {
        return Ficheiro.importaCVScandidaturas(nomeFicheiro, this.data);

    }



    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.OPCOES_CANDIDATURAS;
    }



    @Override
    public boolean voltar(){ 
        if (data.getSituacaoEstados(this.id) == true) {
            changeState( ApoioPoeState.AGUARDA_CONFIGURACAO );
            return true;
        }
        return false; 
    }


    @Override
    public void avancaEstado() {
        changeState( ApoioPoeState.ATRIBUICAO_PROPOSTAS );
  
    }

    @Override
    public boolean fechaEstado() {
        // TODO : impedir fechar se houverem candidaturas sem proposta 

        data.setSituacaoEstados( this.id, false); // estado fechado 
        return true;    
    }



    @Override
    public boolean getSituacaoEstado(){
        return data.getSituacaoEstados(this.id);
    }




    
    
}
