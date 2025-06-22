package com.cashlife.users_microservice.usersmicroservices.userContext.interfaces.rest.transform;


import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.commands.CreatePersonCommand;
import com.cashlife.users_microservice.usersmicroservices.userContext.interfaces.rest.resources.CreatePersonResource;

public class CreatePersonCommandFromResourceAssembler {
    public static CreatePersonCommand toCommandFromResource(CreatePersonResource resource) {
        return new CreatePersonCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.street(),
                resource.number());
    }
}
