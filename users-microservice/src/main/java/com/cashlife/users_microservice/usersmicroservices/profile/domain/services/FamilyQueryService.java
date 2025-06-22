package com.cashlife.users_microservice.usersmicroservices.profile.domain.services;


import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Family;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetAllFamiliesQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetFamilyByIdQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetFamilyByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface FamilyQueryService {
    List<Family> handle(GetAllFamiliesQuery query);
    Optional<Family> handle(GetFamilyByIdQuery query);
    List<Family> handle(GetFamilyByUserIdQuery query);
}
