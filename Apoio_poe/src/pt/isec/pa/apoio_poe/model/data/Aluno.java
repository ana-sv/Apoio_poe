package pt.isec.pa.apoio_poe.model.data;

public class Aluno {

    private Long numEstudante;
    private String nome;
    private String mail;
    private String siglaCurso;
    private String siglaRamo;
    private double classificacao;
    private boolean estagioAcesso;


    
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


    public Aluno( Aluno a ){
        this.numEstudante = a.numEstudante;
        this.nome = a.nome;
        this.mail = a.mail;
        this.siglaCurso = a.siglaCurso;
        this.siglaRamo = a.siglaRamo;
        this.classificacao = a.classificacao;
        this.estagioAcesso = a.estagioAcesso;

    }


    public Aluno(){

    }

    public Long getNumEstudante() {
        return numEstudante;
    }

    public void setNumEstudante( Long n ){
        this.numEstudante = n;
    }

     public String getNome(){
        return nome; 
    }
    public void setNome(String n){
        this.nome = n; 
    }

    public String getEmail() {
        return mail;
    }

    public void setMail(String m ){
        this.mail = m;
    }

    public String getSiglaCurso(){
        return siglaCurso;
    }

    public void setSiglaCurso(String s){
        this.siglaCurso = s;
    }

    public String getSiglaRamo(){
        return siglaRamo;
    }

    public void setSiglaRamo( String r){
        this.siglaRamo = r ; 
    }

    public Double getClassificacao(){
        return classificacao;
    }

    public void setClassifica( Double c){
        this.classificacao = c;
    }

    public Boolean getAcessoEstagio(){
        return estagioAcesso; 
    }

    public void setAcessoEstagio( Boolean c){
        this.estagioAcesso = c;
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
