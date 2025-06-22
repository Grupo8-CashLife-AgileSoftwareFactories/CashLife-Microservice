package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getUSERID(), entity.getUSERNAME(), entity.getPASSWORD(), entity.getEMAIL(), entity.getUSER_TYPE(), entity.getSTATE());
    }
}
