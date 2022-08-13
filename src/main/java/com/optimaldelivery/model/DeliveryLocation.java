package com.optimaldelivery.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "DELIVERY_LOCATION")
public class DeliveryLocation {


    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "source")
    private String source;
    @Column(name = "destination")
    private String destination;
    @Column(name = "distance")
    private int distance;
    @Column(name = "cost")
    private int cost;
}
