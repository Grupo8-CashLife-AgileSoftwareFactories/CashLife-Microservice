package com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.queries;

import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.valueobjects.EmailAddress;

public record GetPersonByEmailQuery(EmailAddress emailAddress) {
}
