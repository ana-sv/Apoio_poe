package pt.isec.pa.apoio_poe.model.data;

import pt.isec.pa.apoio_poe.model.data.Enum.Curso;
import pt.isec.pa.apoio_poe.model.data.Enum.Ramo;

public class Aluno {

    protected Long numEstudante;
    protected String nome;
    protected String mail;
    protected Enum.Curso siglaCurso;
    protected Enum.Ramo siglaRamo;
    protected Float classificacao; 
    protected boolean estagioAcesso;

    
    public Aluno(Long numEstudante, String nome, String mail, Curso siglaCurso, Ramo siglaRamo) {
        this.numEstudante = numEstudante;
        this.nome = nome;
        this.mail = mail;
        this.siglaCurso = siglaCurso;
        this.siglaRamo = siglaRamo;
    }


 

    

    // metodo que insira o acesso ao estagio automaticamente ?




    

}
