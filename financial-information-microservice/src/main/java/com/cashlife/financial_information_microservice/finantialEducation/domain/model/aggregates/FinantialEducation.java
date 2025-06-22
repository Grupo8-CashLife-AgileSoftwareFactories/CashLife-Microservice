package com.cashlife.financial_information_microservice.finantialEducation.domain.model.aggregates;

import com.cashlife.financial_information_microservice.finantialEducation.domain.model.entities.Preguntas;
import com.cashlife.financial_information_microservice.finantialEducation.domain.model.entities.Respuestas;
import com.cashlife.financial_information_microservice.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class FinantialEducation extends AuditableAbstractAggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Preguntas pregunta;

    @ManyToOne
    @JoinColumn(name = "respuesta_id")
    private Respuestas respuesta;

    // Constructor, getters y setters
    public FinantialEducation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Preguntas getPregunta() { return pregunta; }

    public void setPregunta(Preguntas pregunta) { this.pregunta = pregunta; }

    public Respuestas getRespuesta() { return respuesta; }

    public void setRespuesta(Respuestas respuesta) { this.respuesta = respuesta; }
}
