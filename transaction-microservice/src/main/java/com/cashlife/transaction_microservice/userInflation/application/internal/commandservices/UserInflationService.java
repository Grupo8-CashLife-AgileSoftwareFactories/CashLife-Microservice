package com.cashlife.transaction_microservice.userInflation.application.internal.commandservices;

import com.cashlife.transaction_microservice.userInflation.domain.model.UserInflation;
import com.cashlife.transaction_microservice.userInflation.domain.model.UserInflationId;
import com.cashlife.transaction_microservice.userInflation.infraestructure.persistence.jpa.UserInflationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInflationService {

    @Autowired
    private UserInflationRepository repository;

    public void assignReportToUser(Long userId, Long reportId) {
        UserInflation userInflation = new UserInflation(new UserInflationId(userId, reportId));
        repository.save(userInflation);
    }

    public void removeReportFromUser(Long userId, Long reportId) {
        repository.deleteById(new UserInflationId(userId, reportId));
    }
}