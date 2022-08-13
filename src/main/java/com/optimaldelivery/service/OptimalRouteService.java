package com.optimaldelivery.service;

import com.optimaldelivery.model.DeliveryLocation;
import com.optimaldelivery.model.Route;
import com.optimaldelivery.repository.DeliveryLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptimalRouteService {

    final DeliveryLocationRepository deliveryLocationRepository;
    final OptimalRouteFinder optimalRouteFinder;

    public OptimalRouteService(final DeliveryLocationRepository deliveryLocationRepository,
                               final OptimalRouteFinder optimalRouteFinder) {
        this.deliveryLocationRepository = deliveryLocationRepository;
        this.optimalRouteFinder = optimalRouteFinder;
    }

    public List<String> findOptimalRoute(final Route route) {

        final List<DeliveryLocation> deliveryLocations = this.deliveryLocationRepository.findAll();

        /*if(deliveryLocations == null || deliveryLocations.size() <3) {
            return null;
        }*/

        return this.optimalRouteFinder
                   .findOptimalRoute(deliveryLocations, route);
    }
}
