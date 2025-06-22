package com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates;

import com.cashlife.users_microservice.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.commands.CreatePersonCommand;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.valueobjects.EmailAddress;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.valueobjects.PersonName;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.valueobjects.StreetAddress;
import jakarta.persistence.*;

@Entity
public class Person extends AuditableAbstractAggregateRoot<Person> {
    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number"))})
    private StreetAddress address;

    public Person(String firstName, String lastName, String email, String street, String number) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(street, number);
    }

    public Person() {}

    public Person(CreatePersonCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.address = new StreetAddress(command.street(), command.number());
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateAddress(String street, String number) {
        this.address = new StreetAddress(street, number);
    }

    public String getFullName() {return name.getFullName();}

    public String getEmailAddress() {
        return email.address();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }

}
