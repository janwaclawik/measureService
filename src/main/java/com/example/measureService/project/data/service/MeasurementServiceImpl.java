package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.Measurement;
import com.example.measureService.project.data.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService{
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public List<Measurement> getMeasurement() {
        return measurementRepository.findAll();
    }

    @Override
    public void addNewMeasurement(Measurement measurement) {
        if(measurementRepository.findMeasurementByMeasurementId(measurement.getMeasurementId()).isPresent()) {
            throw new IllegalStateException("taken");
        }
        measurementRepository.save(measurement);
    }
}
