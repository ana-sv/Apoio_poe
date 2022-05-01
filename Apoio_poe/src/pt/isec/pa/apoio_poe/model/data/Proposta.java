package pt.isec.pa.apoio_poe.model.data;

import pt.isec.pa.apoio_poe.model.data.Enum.TipoProposta;

public class Proposta {
    protected TipoProposta tipoProp;
    protected String codigoProp;
    protected String titulo;

    public Proposta(TipoProposta tipoProp, String codigoProp, String titulo) {
        this.tipoProp = tipoProp;
        this.codigoProp = codigoProp;
        this.titulo = titulo;
    }

    public Proposta() {
    }

    public String getCodigoProp() {
        return codigoProp;
    }
}
