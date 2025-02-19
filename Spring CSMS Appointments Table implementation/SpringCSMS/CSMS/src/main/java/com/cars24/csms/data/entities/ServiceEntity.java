package com.cars24.csms.data.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name="services")
public class ServiceEntity {
    @Id
    private int service_id;
    @Column(name = "service_name",nullable = false)
    private String service_name;
    @Column(name = "price",nullable = false)
    private int price;

}