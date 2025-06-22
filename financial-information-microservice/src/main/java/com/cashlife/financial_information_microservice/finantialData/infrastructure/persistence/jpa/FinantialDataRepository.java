package com.cashlife.financial_information_microservice.finantialData.infrastructure.persistence.jpa;

import com.cashlife.financial_information_microservice.finantialData.domain.model.FinantialData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinantialDataRepository extends JpaRepository<FinantialData, Long> {
}
