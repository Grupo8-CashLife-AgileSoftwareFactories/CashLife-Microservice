package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.valueObjects.PhoneNumber;

public record CreateFamilyCommand(Long userId, String familyName, int members, String direction, PhoneNumber phoneNumber) {
    public CreateFamilyCommand {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (familyName == null || familyName.isBlank()) {
            throw new IllegalArgumentException("Family name cannot be blank");
        }
        if (members <= 0) {
            throw new IllegalArgumentException("Members must be greater than zero");
        }
        if (direction == null || direction.isBlank()) {
            throw new IllegalArgumentException("Direction cannot be blank");
        }
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
    }
}
