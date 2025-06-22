package com.cashlife.users_microservice.usersmicroservices.profile.application.internal.queryservices;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetAllUsersQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetUserByIdQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.UserQueryService;
import com.cashlife.users_microservice.usersmicroservices.profile.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.id());
    }
}
