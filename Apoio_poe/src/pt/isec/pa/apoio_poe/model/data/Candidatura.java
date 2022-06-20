package pt.isec.pa.apoio_poe.model.data;

import java.util.ArrayList;

public class Candidatura {
    protected Long numEstudante; 
    protected ArrayList<String> listaProp;


    public Candidatura(Long numEstudante, ArrayList<String>  p) {

        this.numEstudante = numEstudante;
        this.listaProp = p;
    }

    public String candidaturaToString() {
      StringBuilder s = new StringBuilder();

        s.append( "\n[" + numEstudante + "]");
        s.append(listaProp);

        return s.toString();
    }


    public Long getNumEstudante(){
        return numEstudante;
    }

    public void setNumEstudante( Long n){
         this.numEstudante = n; 
    }

    public ArrayList<String> getListaPropostas(){
        return listaProp;
    }

    public void setListaPropostas( ArrayList<String> a){
        this.listaProp = a;
        }

    public String getCodigoProposta(int index){
        return listaProp.get(index);
    }

}
