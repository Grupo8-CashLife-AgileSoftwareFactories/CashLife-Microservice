package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreateUserCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.username(), resource.password(), resource.email(), resource.user_type(), resource.state());
    }
}
