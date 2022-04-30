package pt.isec.pa.apoio_poe.model.data;

public class Enum {

    public enum EstadoCandidatura{
        LACRADA,
        ABERTA,
        FECHADA, 
        IMCOMPLETA
    }

    public enum Curso {
        LEI, LEI_PL  // REVER não aceita o - EM VEZ DO _
    }


    public enum Ramo {
        DA, RAS, SI
    }

    public enum Fase {
        ABERTA, FECHADA
    }

    public enum TipoProposta{
        T1, T2, T3
    }

}
