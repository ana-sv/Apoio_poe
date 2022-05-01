package pt.isec.pa.apoio_poe.model.data;

public class Estagio extends Proposta {
    protected String area; 
    protected String entAcolhimento;
    
    public Estagio( String codigoProp, String area, String titulo,String entAcolhimento) {
        this.tipoProp = TipoProposta.T1;
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
        this.entAcolhimento = entAcolhimento;
    }


    
    
}
