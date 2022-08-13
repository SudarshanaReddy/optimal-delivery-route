package com.optimaldelivery.repository;


import com.optimaldelivery.model.DeliveryLocation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;

@Repository
public interface DeliveryLocationRepository extends JpaRepository<DeliveryLocation, Long> {

   /* @Transactional
    @Modifying
    @Query(value = "DELETE FROM DELIVERY_LOCATION dl where dl.source = :source AND dl.destination = :destination", nativeQuery = true)*/
   // List<DeliveryLocation> deleteBySourceAndDestination(@Param("source") String source, @Param("destination") String destination);

    Long deleteBySourceAndDestination(String source, String destination);

}
