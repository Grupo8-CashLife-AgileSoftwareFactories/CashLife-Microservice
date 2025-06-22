package com.cashlife.transaction_microservice.userInflation.infraestructure.persistence.jpa;

import com.cashlife.transaction_microservice.userInflation.domain.model.UserInflation;
import com.cashlife.transaction_microservice.userInflation.domain.model.UserInflationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInflationRepository extends JpaRepository<UserInflation, UserInflationId> {
}
