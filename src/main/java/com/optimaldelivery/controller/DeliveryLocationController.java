package com.optimaldelivery.controller;

import com.optimaldelivery.model.DeliveryLocation;
import com.optimaldelivery.model.Route;
import com.optimaldelivery.model.Users;
import com.optimaldelivery.service.DeliveryLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/delivery-location")
public class DeliveryLocationController {

    private final DeliveryLocationService deliveryLocationService;

    @Autowired
    public DeliveryLocationController(final DeliveryLocationService deliveryLocationService) {
        this.deliveryLocationService = deliveryLocationService;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryLocation> addDeliveryLocation(@RequestBody DeliveryLocation deliveryLocation) {
        return ResponseEntity.ok(this.deliveryLocationService.addDeliveryLocation(deliveryLocation));
    }

    @GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeliveryLocation>> findDeliveryLocations() {
        return ResponseEntity.ok(this.deliveryLocationService.findDeliveryLocation());
    }

    @PostMapping(path = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removeDeliveryLocation(@RequestBody Route route) {
         return ResponseEntity.ok(this.deliveryLocationService.removeDeliveryLocation(route));
    }

    @PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryLocation> updateDeliveryLocation(@RequestBody DeliveryLocation deliveryLocation) {
        return ResponseEntity.ok(this.deliveryLocationService.updateDeliveryLocation(deliveryLocation));
    }
}
