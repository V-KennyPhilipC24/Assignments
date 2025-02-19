package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "user_details")
@Entity

public class AppUserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    private boolean is_enabled;
}
