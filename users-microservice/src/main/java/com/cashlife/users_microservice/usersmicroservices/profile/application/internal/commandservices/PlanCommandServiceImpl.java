package com.cashlife.users_microservice.usersmicroservices.profile.application.internal.commandservices;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Plan;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreatePlanCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.entities.User;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.PlanCommandService;
import com.cashlife.users_microservice.usersmicroservices.profile.infrastructure.persistence.jpa.PlanRepository;
import com.cashlife.users_microservice.usersmicroservices.profile.infrastructure.persistence.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanCommandServiceImpl implements PlanCommandService {

    private final PlanRepository planRepository;
    private final UserRepository userRepository;

    public PlanCommandServiceImpl(PlanRepository planRepository, UserRepository userRepository) {
        this.planRepository = planRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Plan> handle(CreatePlanCommand command) {
        Optional<User> user = userRepository.findById(command.userId());
        if (user.isEmpty()) {
            return Optional.empty();
        }

        Plan plan = new Plan(command, user.get());
        planRepository.save(plan);
        return Optional.of(plan);
    }
}
