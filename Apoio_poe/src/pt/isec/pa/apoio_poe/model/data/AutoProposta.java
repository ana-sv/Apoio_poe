package pt.isec.pa.apoio_poe.model.data;



public class AutoProposta extends Proposta{
    protected Long numEstudante; 

    public AutoProposta( String codigoProp, String titulo, Long numEstudante) {
        this.tipoProp = TipoProposta.T3;
        this.codigoProp = codigoProp;
        this.titulo = titulo;
        this.numEstudante = numEstudante;

    }
    



}