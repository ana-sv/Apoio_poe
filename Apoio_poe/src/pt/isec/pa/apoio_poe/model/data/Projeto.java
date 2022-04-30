package pt.isec.pa.apoio_poe.model.data;

public class Projeto extends Proposta{
    protected Docente orientadorProj;
    protected Long numEstudante;


    public Projeto( String codigoProp, Enum.Ramo area, String titulo) {
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
    }

    
    
}
