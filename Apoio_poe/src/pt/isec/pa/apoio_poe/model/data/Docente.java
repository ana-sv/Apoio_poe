package pt.isec.pa.apoio_poe.model.data;

public class Docente {
    protected String nome;
    protected String mail;

    
    public Docente(String nome, String mail) {
        this.nome = nome;
        this.mail = mail;
    }
    public String getEmail() {
        return mail;
    }
}
