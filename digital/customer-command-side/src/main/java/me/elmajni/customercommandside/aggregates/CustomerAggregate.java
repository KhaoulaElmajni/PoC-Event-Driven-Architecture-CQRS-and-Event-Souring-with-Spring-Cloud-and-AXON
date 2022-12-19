package me.elmajni.customercommandside.aggregates;

import lombok.extern.slf4j.Slf4j;
import me.elmajni.coreapi.commands.CreateCustomCommand;
import me.elmajni.coreapi.events.CustomCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @TargetAggregateIdentifier
    private  String customerId;
    private String name;
    private String email;

    public CustomerAggregate() {
    }

    @CommandHandler
    public CustomerAggregate(CreateCustomCommand command) {
        log.info("CreateCustomCommand received!");
        AggregateLifecycle.apply(new CustomCreatedEvent(
                command.getId(),
                command.getName(),
                command.getEmail()
        ));
    }

    @EventSourcingHandler
    public void on(CustomCreatedEvent event) {
        log.info("CustomCreatedEvent occured!");
        this.customerId = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
    }
}
