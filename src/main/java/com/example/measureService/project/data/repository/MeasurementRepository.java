package com.example.measureService.project.data.repository;

import com.example.measureService.project.data.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, String> {
    Optional<Measurement> findMeasurementByMeasurementId(UUID measurementId);
}
