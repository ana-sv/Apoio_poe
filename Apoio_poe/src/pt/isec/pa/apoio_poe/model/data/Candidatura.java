package pt.isec.pa.apoio_poe.model.data;

import java.util.ArrayList;
import pt.isec.pa.apoio_poe.model.data.Proposta.TipoProposta;

public class Candidatura {
    protected Long numEstudante; 
    protected ArrayList<Proposta> listaProp; 
    protected EstadoCandidatura estadoCand;
    protected Docente orientador;

    
    public enum EstadoCandidatura{
        LACRADA,
        ABERTA,
        FECHADA, 
        IMCOMPLETA
    }



    public Candidatura(Long numEstudante, Proposta p) {

        if( p.tipoProp == TipoProposta.T3 ){ // é autoproposta 
            this.numEstudante = numEstudante;
            this.listaProp = new ArrayList<>(1); // entao só pode ter uma proposta
            listaProp.add(p); 
            this.estadoCand = EstadoCandidatura.FECHADA; // e nao pode ser alterada 

        }else {
            this.numEstudante = numEstudante;
            this.listaProp = new ArrayList<>();
            listaProp.add(p); 
            this.estadoCand = EstadoCandidatura.ABERTA;
        }

    }


    
    

}
