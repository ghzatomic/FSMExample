package br.com.caiopaulucci.fsm.fsmexample;

import org.springframework.statemachine.StateContext;

public class Execucoes {


    public static void inicial(StateContext stateContext){
        stateContext.getExtendedState().getVariables().put("CAMINHO","Iniciou ");
        System.out.println("Inicial ...");
    }

    public static void t1(StateContext stateContext){
        stateContext.getExtendedState().getVariables().put("CAMINHO",stateContext.getExtendedState().getVariables().get("CAMINHO")+" - > T1");
        System.out.println("T1 ...");
    }

    public static void t2(StateContext stateContext){
        stateContext.getExtendedState().getVariables().put("CAMINHO",stateContext.getExtendedState().getVariables().get("CAMINHO")+" - > T2");
        System.out.println("T2 ...");
    }

    public static void fim(StateContext stateContext){
        stateContext.getExtendedState().getVariables().put("CAMINHO",stateContext.getExtendedState().getVariables().get("CAMINHO")+" - > Final");

        System.out.println("Fim ... : "+stateContext.getExtendedState().getVariables().get("CAMINHO"));
    }


}
