package pt.isec.pa.apoio_poe.model.data;

public class Enum {

    public enum EstadoCandidatura{
        LACRADA,
        ABERTA,
        // FALTA ESTADO DE AUTOPROPOSTA- Á TEM ALUNO E PROPOSTA AS NAO ESTA LACRADA
        IMCOMPLETA,
    }

    public enum Curso {
        LEI, LEIP, LEICE  // REVER não aceita o -
    }


    public enum Ramo {
        DA, RAS, SI
    }

    public enum Fase {
        ABERTA, FECHADA
    }

}
