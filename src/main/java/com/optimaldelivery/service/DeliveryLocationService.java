package com.optimaldelivery.service;

import com.optimaldelivery.model.DeliveryLocation;
import com.optimaldelivery.model.Route;
import com.optimaldelivery.repository.DeliveryLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeliveryLocationService {

    private final DeliveryLocationRepository deliveryLocationRepository;

    @Autowired
    public DeliveryLocationService(final DeliveryLocationRepository deliveryLocationRepository) {
        this.deliveryLocationRepository = deliveryLocationRepository;
    }

    public DeliveryLocation addDeliveryLocation(final DeliveryLocation deliveryLocation) {
        return deliveryLocationRepository.save(deliveryLocation);
    }

    public List<DeliveryLocation> findDeliveryLocation() {
        return this.deliveryLocationRepository.findAll();
    }

    public String removeDeliveryLocation(final Route route) {
        final Long result = this.deliveryLocationRepository.deleteBySourceAndDestination(route.getSource(), route.getDestination());

        if(result == 1L) {
            return "Delivery Location Removed:" + route.getSource() + ":" + route.getDestination();
        } else  {
            return "Failed to Delete a Delivery Location";
        }
    }

    public DeliveryLocation updateDeliveryLocation(final DeliveryLocation deliveryLocation) {
        DeliveryLocation foundDeliveryLocation = this.deliveryLocationRepository.findById(deliveryLocation.getId()).get();
        DeliveryLocation updatedLocation = new DeliveryLocation();

        foundDeliveryLocation.setId(deliveryLocation.getId());
        foundDeliveryLocation.setSource(deliveryLocation.getSource());
        foundDeliveryLocation.setDestination(deliveryLocation.getDestination());
        foundDeliveryLocation.setCost(deliveryLocation.getCost());
        foundDeliveryLocation.setDistance(deliveryLocation.getDistance());

        return this.deliveryLocationRepository.save(foundDeliveryLocation);
    }
}
