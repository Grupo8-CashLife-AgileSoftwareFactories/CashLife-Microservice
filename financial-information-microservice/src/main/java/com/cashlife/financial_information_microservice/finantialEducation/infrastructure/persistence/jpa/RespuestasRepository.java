package com.cashlife.financial_information_microservice.finantialEducation.infrastructure.persistence.jpa;

import com.cashlife.financial_information_microservice.finantialEducation.domain.model.entities.Respuestas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestasRepository extends JpaRepository<Respuestas, Long> {
}
