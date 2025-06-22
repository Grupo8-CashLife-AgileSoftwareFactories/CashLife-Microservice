package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Family;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetAllFamiliesQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetFamilyByIdQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetFamilyByUserIdQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.FamilyCommandService;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.FamilyQueryService;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.CreateFamilyResource;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.FamilyResource;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform.CreateFamilyCommandFromResourceAssembler;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform.FamilyResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/families", produces = APPLICATION_JSON_VALUE)
public class FamilyController {
    private final FamilyCommandService familyCommandService;
    private final FamilyQueryService familyQueryService;

    public FamilyController(final FamilyCommandService familyCommandService, final FamilyQueryService familyQueryService) {
        this.familyCommandService = familyCommandService;
        this.familyQueryService = familyQueryService;
    }

    @PostMapping
    public ResponseEntity<FamilyResource> createFamily(@RequestBody CreateFamilyResource resource) {
        Optional<Family> family = familyCommandService.handle(CreateFamilyCommandFromResourceAssembler.toCommandFromResource(resource));
        return family.map(f -> ResponseEntity.created(URI.create("/api/v1/families/" + f.getFAMILY_ID()))
                        .body(FamilyResourceFromEntityAssembler.toResourceFromEntity(f)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<FamilyResource>> getAllFamilies() {
        List<Family> families = familyQueryService.handle(new GetAllFamiliesQuery());
        if (families.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FamilyResource> resources = families.stream()
                .map(FamilyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyResource> getFamilyById(@PathVariable Long id) {
        Optional<Family> family = familyQueryService.handle(new GetFamilyByIdQuery(id));
        return family.map(f -> ResponseEntity.ok(FamilyResourceFromEntityAssembler.toResourceFromEntity(f)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FamilyResource>> getFamiliesByUserId(@PathVariable Long userId) {
        List<Family> families = familyQueryService.handle(new GetFamilyByUserIdQuery(userId));
        if (families.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FamilyResource> resources = families.stream()
                .map(FamilyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }
}
