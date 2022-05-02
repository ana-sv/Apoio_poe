package pt.isec.pa.apoio_poe.model.data;

import pt.isec.pa.apoio_poe.model.data.Proposta.TipoProposta;
import java.util.*;

public class ApoioPoeData {
    HashMap < Long, Aluno > listaAlunos;             // numEstudante, Aluno
    HashMap < String, Docente > listaDocentes;       //mail , Docente
    HashMap < String , Proposta > listaPropostas;    // codigoProp , Proposta
    HashMap< Aluno, Candidatura> listaCandidaturas;
    HashMap< Long, Candidatura> listaCandidatos;

    public ApoioPoeData() {
        this.listaAlunos = new HashMap<>();
        this.listaDocentes = new HashMap<>();
        this.listaPropostas = new HashMap<>();
        this.listaCandidaturas = new HashMap<>();
        this.listaCandidatos = new HashMap<>();
    }



    public String infoCandidaturasToString( Boolean comOrientador){
        StringBuilder str = new StringBuilder();

       Set<Map.Entry<Aluno,Candidatura>> aux = listaCandidaturas.entrySet();
      
       for( Map.Entry<Aluno, Candidatura>  it : aux ){

           str.append( "\n[" + it.getKey().numEstudante + "] ");
           str.append( " " + it.getKey().nome + " : ");

      /*  for (String p : it.getValue().listaProp){
            str.append( " , " + p.getCodigoProp() );
        }*/

       if ( comOrientador = true ){
        str.append(" - " + it.getValue().orientador);
    }
        str.append(" - " + it.getValue().estadoCand );

       }

      
        return str.toString();
    }






    public HashMap < Long, Aluno > getListaAlunos(){
        return listaAlunos;
    }
    public HashMap < String, Docente > getListaDocentes(){
        return listaDocentes;
    }
    public HashMap < String , Proposta  > getListaProposta(){
        return listaPropostas;
    }

    public HashMap < Aluno , Candidatura  > getListaCandidaturas(){
        return listaCandidaturas;
    }

    public HashMap < Long , Candidatura  > getlistaCandidatos(){
        return listaCandidatos;
    }
    public boolean alunoExiste(long numeroAluno){
        return listaAlunos.containsKey(numeroAluno);
    }

    public boolean alunoExiste(String email){
        for(Aluno s : listaAlunos.values()) {
            if(email.equals(s.getEmail()))
                return true;
        }
        return false;
    }

    public void adicionaAluno(long numeroAluno, String nome, String mail, String curso, String ramo, Double classificacao, Boolean estagioAcesso){
        listaAlunos.put(numeroAluno, new Aluno(numeroAluno, nome, mail, curso, ramo, classificacao, estagioAcesso));
    }

    public boolean docenteExiste(String email){
        for(Docente s : listaDocentes.values()) {
            if(email.equals(s.getEmail()))
                return true;
        }
        return false;
    }
    
    public void adicionaDocente(String nome, String mail){
        listaDocentes.put(mail , new Docente(nome, mail));
    }

    public boolean propostaExiste(String codigprop){
        for(Proposta s : listaPropostas.values()) {
            if(codigprop.equals(s.getCodigoProp()))
                return true;
        }
        return false;
    }
    
    public void adicionaEstagio(String codigoProp, String area, String titulo, String entidadeAcolhimento){
            listaPropostas.put(codigoProp , new Estagio(codigoProp, area,titulo, entidadeAcolhimento ));
    }
    public void adicionaProjecto(String codigoProp, String area, String titulo, String mail, Long numEstudante){
            listaPropostas.put(codigoProp , new Projeto(codigoProp, area, titulo, mail, numEstudante));
    }
    public void adicionaAutoProposta(String codigoProp, String titulo, Long numEstudante){
            listaPropostas.put(codigoProp , new AutoProposta(codigoProp,titulo, numEstudante ));
    }
    public void adicionaCandidatura(Long numEstudante, ArrayList<String> lista){
            listaCandidatos.put(numEstudante, new Candidatura(numEstudante,lista));
    }
    public Integer contaAlunos(){
       return  this.listaAlunos.size();
    }

    public Integer contaDocentes(){
        return this.listaDocentes.size();
    }

    public Integer contaPropostas(){
        return this.listaPropostas.size();
    }

    public Integer contaPropostasDA(){
      int n = Collections.frequency(listaPropostas.values(), new Estagio("DA") );   
        n =+ Collections.frequency(listaPropostas.values(), new Projeto("DA") );   
        return n; 

     } 

     public Integer contaPropostasSI(){
        int n = Collections.frequency(listaPropostas.values(), new Estagio("SI") );   
          n =+ Collections.frequency(listaPropostas.values(), new Projeto("SI") );   
          return n; 
  
       } 

       public Integer contaPropostasRAS(){
        int n = Collections.frequency(listaPropostas.values(), new Estagio("RAS") );   
          n =+ Collections.frequency(listaPropostas.values(), new Projeto("RAS") );   
          return n; 
  
       } 
  


    public Integer contaCandidaturas(){
        return this.listaCandidaturas.size();
    }

    

  



    
}
