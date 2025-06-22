package com.cashlife.users_microservice.usersmicroservices.profile.infrastructure.persistence.jpa;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
