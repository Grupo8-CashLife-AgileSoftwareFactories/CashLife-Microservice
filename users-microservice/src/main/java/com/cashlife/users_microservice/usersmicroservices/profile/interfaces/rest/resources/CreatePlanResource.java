package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources;

import java.math.BigDecimal;

public record CreatePlanResource(
        String planName,
        String description,
        BigDecimal cost,
        int monthDuration,
        Long userId
) {
    public CreatePlanResource {
        if (planName == null || planName.isBlank()) {
            throw new IllegalArgumentException("Plan name cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (cost == null || cost.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Cost must be greater than zero");
        }
        if (monthDuration <= 0) {
            throw new IllegalArgumentException("Month duration must be positive");
        }
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
    }
}
