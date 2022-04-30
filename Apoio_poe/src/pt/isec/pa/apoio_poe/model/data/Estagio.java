package pt.isec.pa.apoio_poe.model.data;

public class Estagio extends Proposta {
    protected String entAcolhimento;
    protected Docente orientadorEst;
    protected Long numEstudante;
    
    public Estagio( String codigoProp, Enum.Ramo area, String titulo,String entAcolhimento) {
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
        this.entAcolhimento = entAcolhimento;
    }


    
    
}
