package com.cashlife.users_microservice.usersmicroservices.userContext.interfaces.rest.resources;

public record PersonResource(Long id,
                             String fullName,
                             String email,
                             String streetAddress) {
}
