package pt.isec.pa.apoio_poe.model.data;


public class Estagio extends Proposta {
    protected String area; 
    protected String entAcolhimento;
    
    public Estagio( String codigoProp, String area, String titulo,String entAcolhimento) {
        this.tipo = "T1";
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
        this.entAcolhimento = entAcolhimento;
        this.orientador = null; 
    }

    public Estagio( String ramo){
        this.area = ramo; 
    }


    public String propostasToString(){
        StringBuilder s = new StringBuilder();

        s.append("\n[" + tipo + "] " + " [" + codigoProp + "] ");
   
        s.append( area + " - " + titulo + " - " + entAcolhimento );

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

    public String getTitulo (){
        return this.titulo; 
    }
    
}
