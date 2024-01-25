package com.example.measureService.project.data.repository;


import com.example.measureService.project.data.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceRepository
        extends JpaRepository<Device, String> {

    Optional<Device> findDeviceByDeviceName(String deviceName);
}
