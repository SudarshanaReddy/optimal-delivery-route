package com.optimaldelivery.controller;

import com.optimaldelivery.model.Route;
import com.optimaldelivery.model.Users;
import com.optimaldelivery.service.OptimalRouteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/optimal-route")
public class OptimalRouteController {

    private final OptimalRouteService optimalRouteService;

    public OptimalRouteController(final OptimalRouteService optimalRouteService) {
        this.optimalRouteService = optimalRouteService;
    }

    @GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findOptimalRoute(final Route route) {
        return ResponseEntity.ok((this.optimalRouteService.findOptimalRoute(route)));
    }

}
