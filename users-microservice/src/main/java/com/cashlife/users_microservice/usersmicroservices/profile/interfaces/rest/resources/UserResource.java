package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.valueObjects.State;

public record UserResource(Long user_id, String username, String password, String email, String user_type, State state) {
}
