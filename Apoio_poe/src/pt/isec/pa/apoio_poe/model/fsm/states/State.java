package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.Context;
import pt.isec.pa.apoio_poe.model.fsm.IState;

public enum State {
    
    AGUARDA_CONFIGURACAO,
    MODO_ALUNOS,
    MODO_DOCENTES,
    MODO_PROPOSTAS,

    OPCOES_CANDIDATURAS,
    ATRIBUICAO_PROPOSTAS,
    RESOLVE_EMPATES,

    ATRIBUICAO_ORIENTADORES,
    CONSULTA;



    public IState createState( Context context, Data data ){

         return switch (this){

             case AGUARDA_CONFIGURACAO -> new AguardaConfiguracao(context, data);
             case MODO_ALUNOS -> new ModoAlunos(context,data);
             case MODO_DOCENTES -> new ModoDocentes(context,data);
             case MODO_PROPOSTAS -> new ModoPropostas(context,data);

             case OPCOES_CANDIDATURAS -> new OpcoesCandidaturas(context,data);
             case ATRIBUICAO_PROPOSTAS -> new AtribuicaoPropostas(context,data);
             case RESOLVE_EMPATES -> new ResolveEmpates(context,data);

             case ATRIBUICAO_ORIENTADORES -> new AtribuicaoOrientadores(context,data);
             case CONSULTA -> new Consulta(context,data);

             default -> null; 
         };
    }


}



