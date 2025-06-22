package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Value;

@Value
@Embeddable
public class PhoneNumber {
    String value;

    public PhoneNumber() {
        this.value = "";
    }

    public PhoneNumber(String value) {
        if (!value.matches("\\+?[0-9]{10,15}")) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.value = value;
    }
}
