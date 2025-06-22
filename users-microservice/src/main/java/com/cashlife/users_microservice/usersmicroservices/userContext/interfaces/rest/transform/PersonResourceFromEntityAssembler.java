package com.cashlife.users_microservice.usersmicroservices.userContext.interfaces.rest.transform;


import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates.Person;
import com.cashlife.users_microservice.usersmicroservices.userContext.interfaces.rest.resources.PersonResource;

public class PersonResourceFromEntityAssembler {
    public static PersonResource toResourceFromEntity(Person entity) {
        return new PersonResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getStreetAddress());
    }
}
