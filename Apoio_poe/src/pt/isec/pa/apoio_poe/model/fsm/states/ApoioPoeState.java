package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeIState;

public enum ApoioPoeState {
    
    AGUARDA_CONFIGURACAO,
    MODO_ALUNOS,
    MODO_DOCENTES,
    MODO_PROPOSTAS,

    ORGANIZA_CANDIDATURAS,
    ATRIBUICAO_PROPOSTAS,
    RESOLVE_EMPATES,

    ATRIBUICAO_ORIENTADORES,
    CONSULTA;



    public ApoioPoeIState createState( ApoioPoeContext context, ApoioPoeData data ){

         return switch (this){

             case AGUARDA_CONFIGURACAO -> new AguardaConfiguracao(context, data);
             case MODO_ALUNOS -> new ModoAlunos(context,data);
             case MODO_DOCENTES -> new ModoDocentes(context,data);
             case MODO_PROPOSTAS -> new ModoPropostas(context,data);

             case ORGANIZA_CANDIDATURAS -> new OrganizaCandidaturas(context,data);
             case ATRIBUICAO_PROPOSTAS -> new AtribuicaoPropostas(context,data);
             case RESOLVE_EMPATES -> new ResolveEmpates(context,data);

             case ATRIBUICAO_ORIENTADORES -> new AtribuicaoOrientadores(context,data);
             case CONSULTA -> new Consulta(context,data);

             default -> null; 
         };
    }


}



