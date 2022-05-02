package pt.isec.pa.apoio_poe.model.data;

import java.util.ArrayList;
import pt.isec.pa.apoio_poe.model.data.Proposta.TipoProposta;

public class Candidatura {
    protected Long numEstudante; 
    protected ArrayList<String> listaProp;
    protected EstadoCandidatura estadoCand;
    protected Docente orientador;

    
    public enum EstadoCandidatura{
        LACRADA,
        ABERTA,
        FECHADA, 
        IMCOMPLETA
    }



    public Candidatura(Long numEstudante, ArrayList<String>  p) {

        this.numEstudante = numEstudante;
        this.listaProp = p;

/*        if( p.tipoProp == TipoProposta.T3 ){ // é autoproposta
            this.numEstudante = numEstudante;
            this.listaProp = new ArrayList<>(1); // entao só pode ter uma proposta
            listaProp.add(p); 
            this.estadoCand = EstadoCandidatura.FECHADA; // e nao pode ser alterada 

        }else {
            this.numEstudante = numEstudante;
            this.listaProp = new ArrayList<>();
            listaProp.add(p); 
            this.estadoCand = EstadoCandidatura.ABERTA;
        }*/

    }

    public String candidaturaToString() {
      StringBuilder s = new StringBuilder();

        s.append( "[" + numEstudante + "]");

      /*    for (String p : listaProp){
            s.append( " - " + p.getCodigoProp() );
            s.append( " > " + estadoCand );
        }
*/
        return s.toString();


    }

    public Long getNumEstudante(){
        return numEstudante;
    }

    public ArrayList<String> getListaPropostas(){
        return listaProp;
    }


}

    
    
