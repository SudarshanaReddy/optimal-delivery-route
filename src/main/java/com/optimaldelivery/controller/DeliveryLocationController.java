package com.optimaldelivery.controller;

import com.optimaldelivery.model.DeliveryLocations;
import com.optimaldelivery.model.Users;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/delivery-location")
public class DeliveryLocationController {

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> registerUser(@RequestBody DeliveryLocations deliveryLocation) {
        return ResponseEntity.ok(this.userRegisterService.registerUser(user));
    }

    @PostMapping(path = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        return ResponseEntity.ok(this.userRegisterService.registerUser(user));
    }

    @PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        return ResponseEntity.ok(this.userRegisterService.registerUser(user));
    }

    @PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        return ResponseEntity.ok(this.userRegisterService.registerUser(user));
    }
}
