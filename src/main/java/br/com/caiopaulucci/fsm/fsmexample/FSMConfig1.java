package br.com.caiopaulucci.fsm.fsmexample;

import java.util.EnumSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigBuilder;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachineFactory
public class FSMConfig1 extends EnumStateMachineConfigurerAdapter<States,Events> {


    @Autowired
    private StateMachineListener sMStateListener;

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {

        config.withConfiguration().autoStartup(false).listener(sMStateListener);

        super.configure(config);
    }

    @Override
    public void configure(StateMachineStateConfigurer<States,Events> states)
        throws Exception {


        states
            .withStates()
            .initial(States.ESTADOINICIAL)
            .end(States.FIM)
            .states(EnumSet.allOf(States.class))
        ;

    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States,Events> transitions)
        throws Exception {

        transitions
            .withExternal()
                .source(States.ESTADOINICIAL).action(stateContext -> Execucoes.inicial(stateContext)).target(States.ESTADOT1)
                .and()
            .withExternal()
                .source(States.ESTADOT1).action(stateContext -> Execucoes.t1(stateContext)).target(States.ESTADOT2)
                .and()
            .withExternal()
                .source(States.ESTADOT2).action(stateContext -> Execucoes.t2(stateContext)).target(States.ESTADOFINAL)
                .and()
            .withExternal()
                .source(States.ESTADOFINAL).target(States.FIM).action(stateContext -> Execucoes.fim(stateContext));

    }

}
