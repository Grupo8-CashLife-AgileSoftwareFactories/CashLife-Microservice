package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreateUserCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.valueObjects.State;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter
    private Long USERID;

    @Getter
    @Column(nullable = false)
    private String USERNAME;

    @Getter
    @Column(nullable = false)
    private String PASSWORD;

    @Getter
    @Column(nullable = false)
    private String EMAIL;

    @Getter
    @Column(nullable = false)
    private String USER_TYPE;

    @Enumerated(EnumType.STRING)
    @Getter
    @Column(nullable = false)
    private State STATE;

    @Getter
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date CREATED_DATE;

    protected User() {}

    public User (CreateUserCommand command) {
        this.USERNAME = command.username();
        this.PASSWORD = command.password();
        this.EMAIL = command.email();
        this.USER_TYPE = command.user_type();
        this.STATE = command.state();
    }

    @PrePersist
    protected void onCreate() {
        if (CREATED_DATE == null) {
            CREATED_DATE = new Date();
        }
    }
}
