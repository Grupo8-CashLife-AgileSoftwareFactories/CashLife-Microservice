package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreatePlanCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Plan extends AbstractAggregateRoot<Plan> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long PLANID;

    @Getter
    @ManyToOne
    @JoinColumn(name="USERID", nullable=false)
    private User user;

    @Getter
    @Column(nullable = false)
    private String PLAN_NAME;

    @Getter
    @Lob
    @Column(nullable = false)
    private String DESCRIPTION;

    @Getter
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal COST;

    @Getter
    @Column(nullable = false)
    private int MONTH_DURATION;

    protected Plan() {}

    public Plan(CreatePlanCommand command, User user) {
        this.user = user;
        this.PLAN_NAME = command.planName();
        this.DESCRIPTION = command.description();
        this.COST = command.cost();
        this.MONTH_DURATION = command.monthDuration();
    }
}
