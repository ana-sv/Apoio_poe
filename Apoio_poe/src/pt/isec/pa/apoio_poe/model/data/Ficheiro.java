package pt.isec.pa.apoio_poe.model.data;


import java.io.*; 

public final class Ficheiro {

    private Ficheiro(){    }   // para evitar que ser possivel criar uma classe Ficheiro
    

    public static boolean nomeFicheiroValido(String filename) {
        String[] f = filename.split("\\.");

        if(f.length > 1)
            return false;

        return true;
    }


    public static String exportaCVS( String nomeFicheiro, String str ) {
        
        StringBuilder sb = new StringBuilder();
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        if(!nomeFicheiroValido(nomeFicheiro)){
            return sb.append("ATENCAO! Nome do ficheiro nao e' valido! ").toString();
        }else if(!nomeFicheiro.endsWith(".csv"))
        nomeFicheiro  += ".csv";

        try{
            fw = new FileWriter(nomeFicheiro );
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);


             pw.println( str );


            pw.close();
            bw.close();
            fw.close();
        }catch (FileNotFoundException e){
            sb.append("The specified file was not found");
        }catch (IOException e){
            sb.append("There was an error (IOException)");
        }

        return sb.toString();
    }



















}
