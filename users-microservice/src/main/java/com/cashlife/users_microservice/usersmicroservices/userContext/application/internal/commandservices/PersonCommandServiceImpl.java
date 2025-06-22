package com.cashlife.users_microservice.usersmicroservices.userContext.application.internal.commandservices;

import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates.Person;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.commands.CreatePersonCommand;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.valueobjects.EmailAddress;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.services.PersonCommandService;
import com.cashlife.users_microservice.usersmicroservices.userContext.infrastructure.persistence.jpa.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonCommandServiceImpl implements PersonCommandService {
    private final PersonRepository personRepository;

    public PersonCommandServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> handle(CreatePersonCommand command) {
        var emailAddress = new EmailAddress(command.email());
        if (personRepository.existsByEmail(emailAddress))
            throw new IllegalArgumentException("Person with email " + command.email() + " already exists");
        var person = new Person(command);
        personRepository.save(person);
        return Optional.of(person);
    }
}
