package pt.isec.pa.apoio_poe.model.fsm.states;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import pt.isec.pa.apoio_poe.model.data.*;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

 class OpcoesCandidaturas extends ApoioPoeStateAdapter {
    Fase fase;

     OpcoesCandidaturas(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
        fase = Fase.ABERTA;
    }


    @Override
    public String filtraListasAlunos( Integer q , String filtros ) {  //autoproposta , registada , nao registada
        // TO DO
        return " ";
    }



    @Override
    public String filtraListasPropostas( Integer q ,String filtros ) { // autopropostas, docentes, com candidatura , sem candidatura
        // TO DO
        return " ";
    }

    @Override
    public String mostraListas() {
        StringBuilder s = new StringBuilder();

        s.append("\nCANDIDATURAS");

        for( Candidatura c : data.getListaCandidaturas().values() )
            s.append( c.candidaturaToString() );

        return s.toString();
    }


    @Override
    public String importaCVS(String nomeFicheiro) {

        StringBuilder sb = new StringBuilder();
        long numeroAluno;
        String linha;

        FileReader fr = null;
        BufferedReader br = null;
        Scanner sc = null;


        try{
            fr = new FileReader(nomeFicheiro+".csv");
            br = new BufferedReader(fr);

            while ((linha = br.readLine()) != null) {
                ArrayList<String> codigoPropostas = new ArrayList<>();
                sc = new Scanner(linha);
                sc.useDelimiter(",");

                //Numero Aluno
                if (sc.hasNext()) {
                    String snString = sc.next();
                    if(snString.length()!=10){
                        sb.append("Numero de aluno nao e valido");
                        break;
                    }

                    numeroAluno = Long.parseLong(snString);

                    if (data.alunoExiste(numeroAluno)) {
                        sb.append("Aluno com numero " + numeroAluno + " ja existe\n");
                        break;
                    }
                } else {
                    sb.append("ATENCAO! Numero de aluno nao encontrado");
                    break;
                }

                
                //codigo prop
                while (sc.hasNext()) {
                    codigoPropostas.add(sc.next());
                }

                //Adicionar Aluno
                if(!sc.hasNext())
                    data.adicionaCandidatura(numeroAluno, codigoPropostas);
                else
                    sb.append("Atributos a mais!\n");

            }

            if(sc!=null) sc.close();
            br.close();
            fr.close();
        }catch (FileNotFoundException e){
            sb.append("O ficheiro nao foi encontrado\n");
        }catch (NumberFormatException e){
            sb.append("Argumento deverá ser um numero\n");
        }catch (IOException e){
            sb.append("Houve um erro (IOException)\n");
        }

        return sb.toString();
    }





    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.OPCOES_CANDIDATURAS;
    }



    @Override
    public boolean voltar(){ 
        if ( fase == Fase.ABERTA ){
            changeState( ApoioPoeState.AGUARDA_CONFIGURACAO );
            return true;
        }
        return false; 
    }


    @Override
    public void avanca() {
        changeState( ApoioPoeState.ATRIBUICAO_PROPOSTAS );
  
    }

    @Override
    public boolean fechaFase() {
        // TODO : impedir fechar se houverem candidaturas sem proposta 

        fase = Fase.FECHADA;
        return true;    
    }


    @Override
    public Fase getFase() {
        return this.fase;
    }








    
    
}
