package pt.isec.pa.apoio_poe.model.data;

import pt.isec.pa.apoio_poe.model.data.Proposta.TipoProposta;
import java.util.*;
import java.util.regex.Pattern;

public class ApoioPoeData {
    HashMap < Long, Aluno > listaAlunos;             // numEstudante, Aluno
    HashMap < String, Docente > listaDocentes;       //mail , Docente
    HashMap < String , Proposta > listaPropostas;    // codigoProp , Proposta
    HashMap< Aluno, Candidatura> listaCandidaturas;


    public ApoioPoeData() {
        this.listaAlunos = new HashMap<>();
        this.listaDocentes = new HashMap<>();
        this.listaPropostas = new HashMap<>();
        this.listaCandidaturas = new HashMap<>();
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
    
    public void adicionaProposta(TipoProposta tipoProp, String codigoProp, String titulo){
        listaPropostas.put(codigoProp , new Proposta(tipoProp,codigoProp,titulo ));
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

    public Integer contaCandidaturas(){
        return this.listaCandidaturas.size();
    }

    

    public boolean mailValido(String email) {            
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    



    
}
