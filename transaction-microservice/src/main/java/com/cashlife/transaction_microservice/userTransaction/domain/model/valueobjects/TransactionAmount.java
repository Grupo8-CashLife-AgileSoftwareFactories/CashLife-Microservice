package com.cashlife.transaction_microservice.userTransaction.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;

@Embeddable
public class TransactionAmount {
    private double value;

    @JsonCreator
    public TransactionAmount(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
        this.value = value;
    }

    public TransactionAmount() {

    }

    @JsonValue
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
