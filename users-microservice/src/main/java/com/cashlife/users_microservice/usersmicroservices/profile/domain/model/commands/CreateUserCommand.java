package com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands;


import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.valueObjects.State;

public record CreateUserCommand(String username, String password, String email, String user_type, State state) {
    public CreateUserCommand {
        if (username == null || username.isBlank())
            throw new IllegalArgumentException("Username cannot be blank");
        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password cannot be blank");
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Email cannot be blank");
        if (user_type == null || user_type.isBlank())
            throw new IllegalArgumentException("User_type cannot be blank");
        if (state == null)
            throw new IllegalArgumentException("State must be 'A' or 'I'");
    }
}
