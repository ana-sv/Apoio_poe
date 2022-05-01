package pt.isec.pa.apoio_poe.model.data;

public class Proposta {
    protected TipoProposta tipoProp;
    protected String codigoProp;
    protected String titulo;

    public enum TipoProposta {
        T1, T2, T3
    }

    // ????? nao devia ser possivel criar aqui uma proposta
    // so devia ser possivel criar estagio, projeto ou autoproposta
    public Proposta(TipoProposta tipoProp, String codigoProp, String titulo) {
        this.tipoProp = tipoProp;
        this.codigoProp = codigoProp;
        this.titulo = titulo;
    }

    Proposta(){

    }


    public String getCodigoProp() {
        return codigoProp;
    }

    public String propostasToString(){
        return " ";
    }
    
}
