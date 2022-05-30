package pt.isec.pa.apoio_poe.model.data;

public class Aluno {

    protected Long numEstudante;
    protected String nome;
    protected String mail;
    protected String siglaCurso;
    protected String siglaRamo;
    protected double classificacao;
    protected boolean estagioAcesso;

    
    public Aluno(Long numEstudante, String nome, String mail, String siglaCurso, String siglaRamo, double classificacao ) {
        this.numEstudante = numEstudante;
        this.nome = nome;
        this.mail = mail;
        this.siglaCurso = siglaCurso;
        this.siglaRamo = siglaRamo;

        if ( classificacao >= 0.6 ){
            this.estagioAcesso = true; 
        }
         else if ( classificacao < 0.6 ) {
             this.estagioAcesso = false;
         }

    }


    public Aluno(Long numEstudante, String nome, String mail, String siglaCurso, String siglaRamo, double classificacao, boolean estagioAcesso ) {
        this.numEstudante = numEstudante;
        this.nome = nome;
        this.mail = mail;
        this.siglaCurso = siglaCurso;
        this.siglaRamo = siglaRamo;
        this.classificacao =classificacao;
        this.estagioAcesso = estagioAcesso;
    }

    public Long getNumEstudante() {
        return numEstudante;
    }

     public String getNomeEstudante(){
        return nome; 
    }

    public String getEmail() {
        return mail;
    }

    public String getSiglaCurso(){
        return siglaCurso;
    }

    public String getSiglaRamo(){
        return siglaRamo;
    }

    public Double getClassificacao(){
        return classificacao;
    }

    public Boolean getAcessoEstagio(){
        return estagioAcesso; 
    }

 

    public String alunoToString(){
        StringBuilder s = new StringBuilder();
        s.append("\n[" + numEstudante + "] ");
        s.append( nome + " - " + mail + " - " + siglaCurso +" - " + siglaRamo + " " + classificacao + " - ");
       
        if (estagioAcesso == true )
          s.append(" Estagio : SIM  ");
        else
        s.append(" Estagio : NAO ");

        return s.toString();

    }


    public int compareTo(Aluno value) {
        return Double.compare(this.classificacao, value.classificacao);
    }







    

}
