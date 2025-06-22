package com.cashlife.transaction_microservice.userTransaction.application.internal.queryservices;

import com.cashlife.transaction_microservice.userTransaction.domain.model.aggregates.Transaction;
import com.cashlife.transaction_microservice.userTransaction.infrastructure.persistence.jpa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionQueryServiceImpl {
    private final TransactionRepository transactionRepository;

    public TransactionQueryServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionsByUser(String userId) {
        return transactionRepository.findByUserId(userId);
    }
}
