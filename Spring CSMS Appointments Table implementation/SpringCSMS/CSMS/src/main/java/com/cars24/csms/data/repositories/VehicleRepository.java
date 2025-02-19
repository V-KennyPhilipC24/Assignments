package com.cars24.csms.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cars24.csms.data.entities.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
}