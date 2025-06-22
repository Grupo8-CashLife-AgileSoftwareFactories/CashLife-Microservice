package com.cashlife.users_microservice.usersmicroservices.profile.domain.services;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetAllUsersQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
