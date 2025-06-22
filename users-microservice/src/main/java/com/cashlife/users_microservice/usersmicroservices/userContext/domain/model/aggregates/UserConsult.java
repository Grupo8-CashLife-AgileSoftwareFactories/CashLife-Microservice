package com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_consult")
public class UserConsult {
    @EmbeddedId
    private UserConsultId id;

    // Getters and setters
    public UserConsultId getId() {return id;}

    public void setId(UserConsultId id) {this.id = id;}

}