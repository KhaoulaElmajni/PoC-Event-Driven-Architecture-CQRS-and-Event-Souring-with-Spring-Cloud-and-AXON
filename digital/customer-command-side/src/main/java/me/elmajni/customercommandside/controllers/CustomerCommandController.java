package me.elmajni.customercommandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elmajni.coreapi.commands.CreateCustomCommand;
import me.elmajni.coreapi.dtos.CustomerRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerCommandController {
    private CommandGateway commandGateway;


    public CompletableFuture<String> newCustomer(CustomerRequestDto request) {
        CompletableFuture<String> response = commandGateway.send(new CreateCustomCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getEmail()
        ));
        return response;
    }
}
