package pt.isec.pa.apoio_poe;

import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.ui.text.ApoioPoeUiText;

public class Main {
    public static void main(String[] args) throws Exception {
        ApoioPoeContext apoiopoe = new ApoioPoeContext();
        ApoioPoeUiText ui = new ApoioPoeUiText( apoiopoe) ;
        ui.start(); 
    }
}
