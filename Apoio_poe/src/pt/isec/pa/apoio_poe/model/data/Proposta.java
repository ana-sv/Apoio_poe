package pt.isec.pa.apoio_poe.model.data;

public abstract class Proposta {
    protected TipoProposta tipoProp;
    protected String codigoProp;
    protected String titulo;

    public enum TipoProposta {
        T1, T2, T3
    }


    public String getCodigoProp() {
        return codigoProp;
    }

    public String getRamo(){
        return " ";
    }

    public String propostasToString(){
        return " ";
    }
    
}
