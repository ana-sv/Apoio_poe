package pt.isec.pa.apoio_poe.model.data;

public class Candidatura {
    protected Long codigoCand; 
    protected Aluno a;
    protected Proposta p; 

    public enum EstadoCandidatura{
        LACRADA,
        ABERTA,
        // FALTA ESTADO DE AUTOPROPOSTA- Á TEM ALUNO E PROPOSTA AS NAO ESTA LACRADA
        IMCOMPLETA,
    }

    
    




}
