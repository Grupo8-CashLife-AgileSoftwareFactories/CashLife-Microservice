package com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest;

import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.aggregates.Plan;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.commands.CreatePlanCommand;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetAllPlansQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.model.queries.GetPlanByUserIdQuery;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.PlanCommandService;
import com.cashlife.users_microservice.usersmicroservices.profile.domain.services.PlanQueryService;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.CreatePlanResource;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.resources.PlanResource;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform.CreatePlanCommandFromResourceAssembler;
import com.cashlife.users_microservice.usersmicroservices.profile.interfaces.rest.transform.PlanResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/plans", produces = APPLICATION_JSON_VALUE)
public class PlanController {
    private final PlanCommandService planCommandService;
    private final PlanQueryService planQueryService;

    public PlanController(final PlanCommandService planCommandService, final PlanQueryService planQueryService) {
        this.planCommandService = planCommandService;
        this.planQueryService = planQueryService;
    }

    @PostMapping
    public ResponseEntity<PlanResource> createPlan(@RequestBody CreatePlanResource resource) {
        CreatePlanCommand command = CreatePlanCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Plan> plan = planCommandService.handle(command);

        return plan.map(p -> ResponseEntity.created(URI.create("/api/v1/plans/" + p.getPLANID()))
                        .body(PlanResourceFromEntityAssembler.toResourceFromEntity(p)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<PlanResource>> getAllPlans() {
        List<Plan> plans = planQueryService.handle(new GetAllPlansQuery());
        if (plans.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PlanResource> resources = plans.stream()
                .map(PlanResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<PlanResource> getPlanByUserId(@PathVariable Long userId) {
        Optional<Plan> plan = planQueryService.handle(new GetPlanByUserIdQuery(userId));
        return plan.map(p -> ResponseEntity.ok(PlanResourceFromEntityAssembler.toResourceFromEntity(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
