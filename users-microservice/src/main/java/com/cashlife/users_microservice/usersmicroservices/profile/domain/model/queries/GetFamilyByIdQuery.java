package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries;

public record GetFamilyByIdQuery(Long familyId) {
    public GetFamilyByIdQuery {
        if (familyId == null) {
            throw new IllegalArgumentException("Family ID cannot be null");
        }
    }
}
