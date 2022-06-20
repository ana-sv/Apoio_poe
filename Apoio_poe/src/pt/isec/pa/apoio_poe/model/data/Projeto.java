package pt.isec.pa.apoio_poe.model.data;

public class Projeto extends Proposta{
    protected String area; 
    protected String mailDocente; 
    protected Long numEstudante;


    public Projeto( String codigoProp, String area, String titulo, String mail, Long numEstudante) {
        this.tipo =  "T2";
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
        this.mailDocente = mail;
        this.numEstudante = numEstudante;
        this.orientador = null; 
    }

    public Projeto( String ramo){
        this.area = ramo; 
    }


    public String propostasToString(){
        StringBuilder s = new StringBuilder();

        s.append("\n[" + tipo + "] " + " [" + codigoProp + "] ");
   
        s.append( area + " - " + titulo + " - " + mailDocente +" - " + numEstudante );

        return s.toString();

    }

    public String getRamo(){
        return area;
    }

    public String getTipo(){
        return tipo; 
    }

    public void setTipo(String t){
        this.tipo = t; 
    }

    
    public void getTitulo(String t){
        this.titulo = t; 
    }

    public String getTitulo(){
        return this.titulo; 
    }


    public void setArea( String a){
        this.area = a; 
    }

    public String getArea(){
        return this.area;
    }
    
    
}
