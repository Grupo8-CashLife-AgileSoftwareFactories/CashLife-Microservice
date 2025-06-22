package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands;

import java.math.BigDecimal;

public record CreatePlanCommand(Long userId, String planName, String description, BigDecimal cost, int monthDuration) {

    public CreatePlanCommand {
        if (userId <= 0) {
            throw new IllegalArgumentException("User ID must be greater than 0");
        }
        if (planName == null || planName.isBlank()) {
            throw new IllegalArgumentException("Plan name cannot be blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be blank");
        }
        if (cost == null || cost.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Cost must be greater than 0");
        }
        if (monthDuration <= 0) {
            throw new IllegalArgumentException("Month duration must be greater than 0");
        }
    }
}
