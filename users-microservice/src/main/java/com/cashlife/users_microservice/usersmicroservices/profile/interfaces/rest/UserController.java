package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetAllUsersQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetUserByIdQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.UserCommandService;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.UserQueryService;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.CreateUserResource;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.UserResource;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/users", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(final UserCommandService userCommandService, final UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        Optional<User> user = userCommandService.handle(CreateUserCommandFromResourceAssembler.toCommandFromResource(resource));
        return user.map(source -> new ResponseEntity<>(UserResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {
        List<User> users = userQueryService.handle(new GetAllUsersQuery());
        List<UserResource> resources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(id));
        return user.map(value -> ResponseEntity.ok(UserResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
