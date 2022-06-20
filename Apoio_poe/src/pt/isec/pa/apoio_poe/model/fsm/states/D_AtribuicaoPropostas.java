package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.data.Data;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.StateAdapter;

class D_AtribuicaoPropostas extends StateAdapter {
    private Integer index = 2;

    D_AtribuicaoPropostas(ApoioPoeContext context, Data data) {
        super(context, data);
    }

    public boolean atribuicaoAuto() {

        if (data.getSituacaoEstados(index) == true) { // se esta fase está aberta , entao começa a atribuir

            for (Candidatura a : data.getListaCandidaturas().values()) {

                if (!data.alunoExisteListaFinal(a.getNumEstudante())) { // se o aluno ainda nao está na lista final
                                                                        // definitiva

                    if ( a.getListaPropostas().contains("T3")) {
                        data.getListaFinal().put(a.getNumEstudante(), a.getCodigoProposta(0));
                         // a lista de propostas já é um array com codigos das propostas
                         data.getListaCandidaturas().remove(a.getNumEstudante());  
                    }

                }  else {


                     // SE o proximo aluno tem a mesma primeira opção que outros na lista 
                      // e se for estágio ve se tem nota para tal , se não tiver nota testa a segunda opção 

                     // adiciona-nos na lista de empates 
                     // vai ao estado desempatar e volta?

                     // SE nao , atribui a primeira opção 



                }


     


            }

        }

        return false; // "Estado Fechado, nao pode fazer nada disto

    }

    public String filtraListasAlunos(Integer q, String filtros) {
        // TO DO
        return " nao implementado ainda";
    }

    public String filtraListasPropostas(Integer q, String filtros) {
        // TO DO
        return " nao implementado ainda";
    }

    public String mostraListas() { // MUDAR PARA DADOS??
        StringBuilder s = new StringBuilder();

        s.append(data.infoCandidaturasToString(false));

        return s.toString();
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.ATRIBUICAO_PROPOSTAS;
    }

    @Override
    public void avancaEstado() {
        changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
    }

    @Override
    public boolean fechaEstado() {

        // REVER

        // Apenas será possível fechar esta fase se todos os alunos com candidaturas
        // submetidas possuírem projeto atribuído
        if (data.getListaCandidaturas().containsValue(null)) {
            return false;
        } else {
            changeState(ApoioPoeState.ATRIBUICAO_ORIENTADORES);
            return true;
        }
    }

    @Override
    public boolean voltar() {
        if (data.getSituacaoEstados(this.index) == true) {
            changeState(ApoioPoeState.OPCOES_CANDIDATURAS);
            return true;
        }
        return false;

    }

    @Override
    public boolean getSituacaoEstado() {
        return data.getSituacaoEstados(this.index);
    }

}
