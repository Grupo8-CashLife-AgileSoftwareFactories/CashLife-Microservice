package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreatePlanCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.CreatePlanResource;

public class CreatePlanCommandFromResourceAssembler {
    public static CreatePlanCommand toCommandFromResource(CreatePlanResource resource) {
        return new CreatePlanCommand(
                resource.userId(),
                resource.planName(),
                resource.description(),
                resource.cost(),
                resource.monthDuration()
        );
    }
}
