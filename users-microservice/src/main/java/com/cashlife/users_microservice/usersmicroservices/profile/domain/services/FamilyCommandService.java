package com.cashlife.users_microservice.usersmicroservices.profile.domain.services;


import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Family;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreateFamilyCommand;

import java.util.Optional;

public interface FamilyCommandService {
    Optional<Family> handle(CreateFamilyCommand command);
}
