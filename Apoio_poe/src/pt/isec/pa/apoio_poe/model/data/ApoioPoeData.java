package pt.isec.pa.apoio_poe.model.data;
import java.util.*;

public class ApoioPoeData {
    HashMap < Long, Aluno > listaAlunos; 
    HashMap < Long, Docente > listaDocentes;
    HashMap < Long , Proposta > listaPropostas; 
    HashMap<String, Wrapper> listaCandidaturas;


    public ApoioPoeData() {
        this.listaAlunos = new HashMap<>();
        this.listaDocentes = new HashMap<>();
        this.listaPropostas = new HashMap<>();
        this.listaCandidaturas = new HashMap<String, Wrapper>();
        setup();
    }
    private void setup(){
        this.listaCandidaturas.put("DA", new Wrapper(0, 0));   // each branch starts with 0 students and 0 proposals -> to be incremented as they're created
        this.listaCandidaturas.put("RAS", new Wrapper(0, 0));   // each branch starts with 0 students and 0 proposals -> to be incremented as they're created
        this.listaCandidaturas.put("SI", new Wrapper(0, 0));   // each branch starts with 0 students and 0 proposals -> to be incremented as they're created
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

    public void adicionaAluno(long numeroAluno, String nome, String mail, String curso, String ramo){
        listaAlunos.put(numeroAluno, new Aluno(numeroAluno, nome, mail, curso, ramo));
        listaCandidaturas.get(ramo).incrementNumeroAlunos();
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
    
    private class Wrapper{    // to be used on 'numberStudents' hashmap
        int numeroAlunos;    // number of students in that branch
        int numeroPropostas;   // number of proposals destined for that branch

        public Wrapper(int numeroAlunos, int numeroPropostas) {
            this.numeroAlunos = numeroAlunos;
            this.numeroPropostas = numeroPropostas;
        }

        public int getNumeroAlunos() { return numeroAlunos; }
        public int getNumeroPropostas() { return numeroPropostas; }
        public void setNumeroPropostas(int nmrProposals) { this.numeroPropostas = nmrProposals; }
        public void setNumeroAlunos(int nmrStudents) { this.numeroAlunos = nmrStudents; }
        public void incrementNumeroPropostas() { numeroPropostas++; }
        public void incrementNumeroAlunos() { numeroAlunos++; }

    }







    


    
}
