package com.cashlife.financial_information_microservice.finantialEducation.infrastructure.persistence.jpa;

import com.cashlife.financial_information_microservice.finantialEducation.domain.model.entities.Preguntas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasRepository extends JpaRepository<Preguntas, Long> {
}
