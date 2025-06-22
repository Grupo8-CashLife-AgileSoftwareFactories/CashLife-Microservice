package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates;


import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreateFamilyCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.valueObjects.PhoneNumber;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Family extends AbstractAggregateRoot<Family> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long FAMILY_ID;

    @Getter
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Getter
    @Column(nullable=false)
    private String FAMILY_NAME;

    @Getter
    @Column(nullable=false)
    private int MEMBERS;

    @Getter
    @Column(nullable=false)
    private String DIRECTION;

    @Embedded
    @Getter
    @Column(nullable=false)
    private PhoneNumber PHONE_NUMBER;

    protected Family() {}

    public Family(CreateFamilyCommand command, User user) {
        this.user = user;
        this.FAMILY_NAME = command.familyName();
        this.MEMBERS = command.members();
        this.DIRECTION = command.direction();
        this.PHONE_NUMBER = command.phoneNumber();
    }
}
