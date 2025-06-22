package com.cashlife.users_microservice.usersmicroservices.profile.infrastructure.persistence.jpa;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<Family> findByUser_USERID(Long userId);
}
