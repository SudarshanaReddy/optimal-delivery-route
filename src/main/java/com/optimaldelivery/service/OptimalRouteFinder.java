package com.optimaldelivery.service;

import com.optimaldelivery.model.DeliveryLocation;
import com.optimaldelivery.model.Route;
import com.optimaldelivery.repository.DeliveryLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OptimalRouteFinder {

    private final DeliveryLocationRepository deliveryLocationRepository;

    private List<String> finalPath = new ArrayList<>();

    @Autowired
    public OptimalRouteFinder(final DeliveryLocationRepository deliveryLocationRepository) {
        this.deliveryLocationRepository = deliveryLocationRepository;
    }

    public List<String> findOptimalRoute(final List<DeliveryLocation> deliveryLocationList, final Route route) {

        if(deliveryLocationList!=null) {
            if(deliveryLocationList.get(0).getDestination().equalsIgnoreCase(route.getDestination())) {
                finalPath.add(deliveryLocationList.get(0).getDestination());
                return finalPath;
            }
        }

       final List<DeliveryLocation> neighbours = findNeighbours(deliveryLocationList, route.getSource());

       return findOptimalRoute(neighbours, route);
    }

    private List<DeliveryLocation> findNeighbours(final List<DeliveryLocation> deliveryLocationList,
                                                  final String source) {
        return  deliveryLocationList
                .stream()
                .filter(dl -> dl.getSource().equalsIgnoreCase(source))
                .collect(Collectors.toList());
    }
}
