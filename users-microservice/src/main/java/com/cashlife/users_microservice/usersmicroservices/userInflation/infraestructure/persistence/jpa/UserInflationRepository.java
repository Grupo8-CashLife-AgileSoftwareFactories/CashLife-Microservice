package com.cashlife.users_microservice.usersmicroservices.userInflation.infraestructure.persistence.jpa;

import com.cashlife.users_microservice.usersmicroservices.userInflation.domain.model.UserInflation;
import com.cashlife.users_microservice.usersmicroservices.userInflation.domain.model.UserInflationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInflationRepository extends JpaRepository<UserInflation, UserInflationId> {
}
