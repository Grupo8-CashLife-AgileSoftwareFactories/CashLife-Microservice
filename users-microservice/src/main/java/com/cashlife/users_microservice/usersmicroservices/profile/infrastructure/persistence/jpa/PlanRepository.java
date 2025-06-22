package com.cashlife.users_microservice.usersmicroservices.profile.infrastructure.persistence.jpa;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
