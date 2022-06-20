package pt.isec.pa.apoio_poe.model.data;

public abstract class Proposta {
    protected String tipo;
    protected String codigoProp;
    protected String titulo;
    protected Docente orientador;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public void getTitulo(String t) {
        this.titulo = t;
    }

    public String getCodigoProp() {
        return codigoProp;
    }

    public void setCodigoProp(String c) {
        this.codigoProp = c;
    }

    public String getRamo() {
        return " ";
    }

    public String propostasToString() {
        return " ";
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaildocente(){
        return this.orientador.getMail(); 
    }

    public void setMailOrientador(String m){
        this.orientador.mail = m;
    }


}
