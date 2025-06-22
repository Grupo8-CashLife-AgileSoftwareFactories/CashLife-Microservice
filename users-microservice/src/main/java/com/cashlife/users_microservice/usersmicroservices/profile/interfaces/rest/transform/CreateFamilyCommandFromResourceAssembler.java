package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreateFamilyCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.CreateFamilyResource;

public class CreateFamilyCommandFromResourceAssembler {
    public static CreateFamilyCommand toCommandFromResource(CreateFamilyResource resource) {
        return new CreateFamilyCommand(
                resource.userId(),
                resource.familyName(),
                resource.members(),
                resource.direction(),
                resource.phoneNumber()
        );
    }
}
