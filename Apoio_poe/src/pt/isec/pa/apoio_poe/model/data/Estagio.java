package pt.isec.pa.apoio_poe.model.data;

import pt.isec.pa.apoio_poe.model.data.Enum.*;

public class Estagio extends Proposta {
    protected Enum.Ramo area; 
    protected String entAcolhimento;
    
    public Estagio( String codigoProp, Enum.Ramo area, String titulo,String entAcolhimento) {
        this.tipoProp = TipoProposta.T1;
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
        this.entAcolhimento = entAcolhimento;
    }


    
    
}
