package com.cashlife.transaction_microservice.userTransaction.domain.services;

public class TransactionDomainService {
    public boolean validateTransaction(double amount) {
        return amount > 0;
    }
}
