package pt.isec.pa.apoio_poe.model.fsm.states;
import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeIState;

public enum ApoioPoeState {

    INICIO,    
    AGUARDA_CONFIGURACAO,
    MODO_ALUNOS,
    MODO_DOCENTES,
    MODO_PROPOSTAS,

    OPCOES_CANDIDATURAS,
    ATRIBUICAO_PROPOSTAS,
    RESOLVE_EMPATES,

    ATRIBUICAO_ORIENTADORES,
    CONSULTA;



    public ApoioPoeIState createState( ApoioPoeContext context, Data data ){

         return switch (this){
             case INICIO -> new A_Inicio(context, data);
             case AGUARDA_CONFIGURACAO -> new A_AguardaConfiguracao(context, data);
             case MODO_ALUNOS -> new B_ModoAlunos(context,data);
             case MODO_DOCENTES -> new B_ModoDocentes(context,data);
             case MODO_PROPOSTAS -> new B_ModoPropostas(context,data);

             case OPCOES_CANDIDATURAS -> new C_OpcoesCandidaturas(context,data);
             case ATRIBUICAO_PROPOSTAS -> new D_AtribuicaoPropostas(context,data);
             case RESOLVE_EMPATES -> new E_ResolveEmpates(context,data);

             case ATRIBUICAO_ORIENTADORES -> new F_AtribuicaoOrientadores(context,data);
             case CONSULTA -> new G_Consulta(context,data);

             default -> null; 
         };
    }


}



