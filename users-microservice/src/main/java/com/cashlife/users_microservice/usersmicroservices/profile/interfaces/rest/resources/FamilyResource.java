package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.valueObjects.PhoneNumber;

public record FamilyResource(Long familyId, Long userId, String familyName, int members, String direction, PhoneNumber phoneNumber) {
}
