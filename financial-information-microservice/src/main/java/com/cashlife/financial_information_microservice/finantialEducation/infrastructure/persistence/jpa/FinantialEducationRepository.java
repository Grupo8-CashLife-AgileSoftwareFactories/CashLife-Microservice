package com.cashlife.financial_information_microservice.finantialEducation.infrastructure.persistence.jpa;

import com.cashlife.financial_information_microservice.finantialEducation.domain.model.aggregates.FinantialEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinantialEducationRepository extends JpaRepository<FinantialEducation, Long> {
}
