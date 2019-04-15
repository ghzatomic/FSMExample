package br.com.caiopaulucci.fsm.fsmexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;


@Component
public class CommandLineRunner1 implements CommandLineRunner {


    @Autowired
    StateMachineFactory<States, Events> stateMachineFactory;


    @Override
    public void run(String... args) throws Exception {
        stateMachineFactory.getStateMachine().start();
    }



}
