package pt.isec.pa.apoio_poe.ui.text;

import pt.isec.pa.apoio_poe.model.fsm.Context;

public class MainTxt {
    public static void main(String[] args) throws Exception {
        Context apoiopoe = new Context();
        ApoioPoeUiText ui = new ApoioPoeUiText( apoiopoe) ;
        ui.start(); 
    }
}
