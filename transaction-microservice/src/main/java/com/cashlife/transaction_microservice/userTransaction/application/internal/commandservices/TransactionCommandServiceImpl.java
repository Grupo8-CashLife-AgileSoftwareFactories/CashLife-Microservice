package com.cashlife.transaction_microservice.userTransaction.application.internal.commandservices;

import com.cashlife.transaction_microservice.userTransaction.domain.model.aggregates.Transaction;
import com.cashlife.transaction_microservice.userTransaction.infrastructure.persistence.jpa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionCommandServiceImpl {
    private final TransactionRepository transactionRepository;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction command) {
        Transaction transaction = new Transaction();
        transaction.setDescription(command.getDescription());
        transaction.setAmount(command.getAmount());
        transaction.setDate(command.getDate());
        transaction.setCategory(command.getCategory());
        transaction.setUserId(command.getUserId());
        return transactionRepository.save(transaction);
    }
}
