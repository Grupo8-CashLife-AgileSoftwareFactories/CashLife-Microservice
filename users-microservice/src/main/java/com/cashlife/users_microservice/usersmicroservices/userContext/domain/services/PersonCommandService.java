package com.cashlife.users_microservice.usersmicroservices.userContext.domain.services;

import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates.Person;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.commands.CreatePersonCommand;

import java.util.Optional;

public interface PersonCommandService {
    Optional<Person> handle(CreatePersonCommand command);
}
