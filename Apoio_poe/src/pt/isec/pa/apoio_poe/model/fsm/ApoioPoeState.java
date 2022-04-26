package pt.isec.pa.apoio_poe.model.fsm;

public enum ApoioPoeState {
    MODO_ALUNOS,
    MODO_DOCENTES,
    MODO_PROPOSTAS,
    AGUARDA_CONFIGURACAO,
    ORGANIZA_CANDIDATURAS,
    ORGANIZA_EMPATE,
    ATRIBUICAO_PROPOSTAS,
    ATRIBUICAO_ORIENTADORES,
    CONSULTA,
    FICHEIROSCVS;



    public ApoioPoeIState createState( ApoioPoeContext context){
         return switch (this){
             default -> null; 
         };
    }


}



