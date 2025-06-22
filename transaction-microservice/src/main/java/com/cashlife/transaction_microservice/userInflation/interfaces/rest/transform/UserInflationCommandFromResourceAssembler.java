package com.cashlife.transaction_microservice.userInflation.interfaces.rest.transform;

import com.cashlife.transaction_microservice.userInflation.domain.model.UserInflation;
import com.cashlife.transaction_microservice.userInflation.domain.model.UserInflationId;
import com.cashlife.transaction_microservice.userInflation.interfaces.rest.resources.UserInflationResource;
import org.springframework.stereotype.Component;

@Component
public class UserInflationCommandFromResourceAssembler {

    public UserInflation toEntity(UserInflationResource resource) {
        UserInflation userInflation = new UserInflation();
        userInflation.setId(new UserInflationId(resource.getUserId(), resource.getReportId()));
        return userInflation;
    }
}
