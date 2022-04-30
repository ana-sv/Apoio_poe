package pt.isec.pa.apoio_poe.model.data;

import pt.isec.pa.apoio_poe.model.data.Enum.*;

public class Projeto extends Proposta{
    protected Enum.Ramo area; 
    protected String mailDocente; 
    protected Long numEstudante;


    public Projeto( String codigoProp, Enum.Ramo area, String titulo, String mail, Long numEstudante) {
        this.tipoProp = TipoProposta.T2;
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
        this.mailDocente = mail;
        this.numEstudante = numEstudante;
    }

    
    
}
