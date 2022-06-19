package pt.isec.pa.apoio_poe.model.data;

import java.util.regex.Pattern;

public class Docente {
    protected String nome;
    protected String mail;

    
    public Docente(String nome, String mail) {
        this.nome = nome;
        this.mail = mail;
    }


    public String getNome(){
      return this.nome; 
    }

    public void setNome(String n){
        this.nome = n; 
    }


    public String getEmail() {
        return mail;
    }

    
    public static boolean mailValido(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    //  TODO verificao de mail 
    public void setMail( String mail){   
  //  public boolean setMail( String mail ){
      /*  if (mailValido(mail)){
            this.mail = mail; 
            System.out.println("Mail inserido valido ");
            return true; 
        }
        System.out.println("Mail inserido nao é valido ");
        return false; */
        this.mail = mail; 
    }

    public String DocentesToString(){
        StringBuilder s = new StringBuilder();
        s.append("\n[" + mail + "] " + nome );
        return s.toString();
    }






}
