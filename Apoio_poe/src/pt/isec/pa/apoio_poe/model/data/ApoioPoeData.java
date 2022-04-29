package pt.isec.pa.apoio_poe.model.data;
import java.util.*;

public class ApoioPoeData {
    HashMap < Long, Aluno > listaAlunos; 
    HashMap < Long, Docente > listaDocentes;
    HashMap < Long , Proposta > listaPropostas; 
    HashMap < Long, Candidatura > listaCandidaturas;


    public ApoioPoeData() {
        this.listaAlunos = new HashMap<>();
        this.listaDocentes = new HashMap<>();
        this.listaPropostas = new HashMap<>();
        this.listaCandidaturas = new HashMap<>();

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
