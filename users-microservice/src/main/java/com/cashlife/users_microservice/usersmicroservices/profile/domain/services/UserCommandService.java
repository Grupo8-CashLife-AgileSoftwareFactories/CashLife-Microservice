package com.cashlife.users_microservice.usersmicroservices.profile.domain.services;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreateUserCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
}
