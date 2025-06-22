package com.cashlife.users_microservice.usersmicroservices.userContext.interfaces.rest;

import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates.UserConsult;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.aggregates.UserConsultId;
import com.cashlife.users_microservice.usersmicroservices.userContext.infrastructure.persistence.jpa.repositories.UserConsultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user_consults", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserConsultController {
    private final UserConsultRepository UserConsultRepository;

    public UserConsultController(UserConsultRepository UserConsultRepository) {
        this.UserConsultRepository = UserConsultRepository;
    }

    @PostMapping
    public ResponseEntity<UserConsult> createUserConsult(@RequestBody UserConsult UserConsult) {
        UserConsult savedUserConsult = UserConsultRepository.save(UserConsult);
        return new ResponseEntity<>(savedUserConsult, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserConsult>> getAllUserConsults() {
        List<UserConsult> userConsults = UserConsultRepository.findAll();
        return ResponseEntity.ok(userConsults);
    }

    @GetMapping("/{userId}/{consultId}")
    public ResponseEntity<UserConsult> getUserConsult(@PathVariable Long userId, @PathVariable Long consultId) {
        UserConsultId id = new UserConsultId();
        id.setUserId(userId);
        id.setConsultId(consultId);
        return UserConsultRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{userId}/{consultId}")
    public ResponseEntity<Void> deleteUserConsult(@PathVariable Long userId, @PathVariable Long consultId) {
        UserConsultId id = new UserConsultId();
        id.setUserId(userId);
        id.setConsultId(consultId);
        UserConsultRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}