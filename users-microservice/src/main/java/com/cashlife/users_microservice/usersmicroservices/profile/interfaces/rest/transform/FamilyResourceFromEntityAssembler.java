package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Family;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.FamilyResource;

public class FamilyResourceFromEntityAssembler {
    public static FamilyResource toResourceFromEntity(Family entity) {
        return new FamilyResource(
                entity.getFAMILY_ID(),
                entity.getUser().getUSERID(),
                entity.getFAMILY_NAME(),
                entity.getMEMBERS(),
                entity.getDIRECTION(),
                entity.getPHONE_NUMBER()
        );
    }
}
