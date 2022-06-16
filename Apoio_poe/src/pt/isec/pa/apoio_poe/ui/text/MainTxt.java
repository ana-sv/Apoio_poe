package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;

public class MainTxt {
    public static void main(String[] args) throws Exception {
        ApoioPoeContext apoiopoe = new ApoioPoeContext();
        ApoioPoeUiText ui = new ApoioPoeUiText( apoiopoe) ;
        ui.start(); 
    }
}
