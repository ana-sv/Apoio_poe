package pt.isec.pa.apoio_poe.model.data;

public class AutoProposta extends Proposta{
    protected Aluno aluno;
    protected Docente orientador;


    public AutoProposta( String codigoProp, Enum.Ramo area, String titulo,Aluno aluno, Docente orientador) {
        this.codigoProp = codigoProp;
        this.area = area;
        this.titulo = titulo;
        this.aluno = aluno;
        this.orientador = orientador;
    }
    



}