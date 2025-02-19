package com.cars24.csms.data.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name="customers")
public class CustomerEntity {
    @Id
//    @Column(name = "customer_id")
    private int customerId;
    //    @Column(name = "name")
    private String name;
    //    @Column(name = "email")
    private String email;
    //    @Column(name = "address")
    private String address;
    //    @Column(name = "phone")
    private String phone;
}