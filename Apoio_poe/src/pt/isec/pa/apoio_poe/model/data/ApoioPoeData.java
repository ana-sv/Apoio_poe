package pt.isec.pa.apoio_poe.model.data;
import java.util.*;

public class ApoioPoeData {
    HashMap < Long, Aluno > listaAlunos; 
    HashMap < String, Docente > listaDocentes;
    HashMap < Long , Proposta > listaPropostas; 
    HashMap<String, Candidatura> listaCandidaturas;


    public ApoioPoeData() {
        this.listaAlunos = new HashMap<>();
        this.listaDocentes = new HashMap<>();
        this.listaPropostas = new HashMap<>();
        this.listaCandidaturas = new HashMap<String, Candidatura>();
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

    public void adicionaAluno(long numeroAluno, String nome, String mail, String curso, String ramo, double classificacao, Boolean estagioAcesso){
        listaAlunos.put(numeroAluno, new Aluno(numeroAluno, nome, mail, curso, ramo, classificacao, estagioAcesso));
    }
    public boolean docenteExiste(String email){
        for(Aluno s : listaAlunos.values()) {
            if(email.equals(s.getEmail()))
                return true;
        }
        return false;
    }

    public void adicionaDocente(String nome, String mail){
        listaDocentes.put(mail , new Docente(nome, mail));
    }

    // TODO
        // ADICIONAR ALUNOS 
        // ADDICIONAR DOCENTES 
        // ADICIONAR PROPOSTAS 
        // .....




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
    



    
}
