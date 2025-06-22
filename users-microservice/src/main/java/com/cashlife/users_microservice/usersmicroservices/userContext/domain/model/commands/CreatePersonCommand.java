package com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.commands;

public record CreatePersonCommand(String firstName,
                                  String lastName,
                                  String email,
                                  String street,
                                  String number) {
}
