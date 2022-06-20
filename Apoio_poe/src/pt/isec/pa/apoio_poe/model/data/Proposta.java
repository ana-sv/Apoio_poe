package pt.isec.pa.apoio_poe.model.data;

public abstract class Proposta {
    protected String tipo;
    protected String codigoProp;
    protected String titulo;
    protected Docente orientador;



    public String getCodigoProp() {
        return codigoProp;
    }

    public String getRamo(){
        return " ";
    }

    public String propostasToString(){
        return " ";
    }

    public  String getTipo(){
        return tipo; 
    }

    
    
}
