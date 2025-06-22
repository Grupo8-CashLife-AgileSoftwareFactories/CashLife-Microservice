package com.cashlife.users_microservice.usersmicroservices.profile.domain.services;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Plan;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreatePlanCommand;

import java.util.Optional;

public interface PlanCommandService {
    Optional<Plan> handle(CreatePlanCommand command);
}
