package com.example.measureService.project.data.repository;

import com.example.measureService.project.data.domain.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, UUID> {
    Optional<DeviceType> findDeviceTypeByDeviceBrand(String deviceBrand);

}
