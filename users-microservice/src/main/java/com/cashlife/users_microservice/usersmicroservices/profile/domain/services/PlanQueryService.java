package com.cashlife.users_microservice.usersmicroservices.profile.domain.services;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Plan;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetAllPlansQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetPlanByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface PlanQueryService {
    List<Plan> handle(GetAllPlansQuery query);
    Optional<Plan> handle(GetPlanByUserIdQuery query);
}
