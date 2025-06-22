package com.cashlife.users_microservice.usersmicroservices.userContext.infrastructure.persistence.jpa.repositories;

import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates.UserConsult;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates.UserConsultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConsultRepository extends JpaRepository<UserConsult, UserConsultId> { }

