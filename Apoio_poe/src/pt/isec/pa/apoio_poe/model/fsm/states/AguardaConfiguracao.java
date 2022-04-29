package pt.isec.pa.apoio_poe.model.fsm.states;

import pt.isec.pa.apoio_poe.model.data.ApoioPoeData;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeContext;
import pt.isec.pa.apoio_poe.model.fsm.ApoioPoeStateAdapter;

/*

NOTAS DE IMPLEMENTAÇAO 

Default: When no access modifier is specified for a class, method, or data member 
– It is said to be having the default access modifier by default. 

The data members, class or methods which are not declared using any
access modifiers i.e. having default access modifier are accessible only within the same package.


*/

class AguardaConfiguracao extends ApoioPoeStateAdapter {

    AguardaConfiguracao(ApoioPoeContext context, ApoioPoeData data) {
        super(context, data);
    }

    @Override
    public ApoioPoeState getState() {
        return ApoioPoeState.AGUARDA_CONFIGURACAO;
    }


    
}
