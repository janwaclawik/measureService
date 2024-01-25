package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.Measurement;

import java.util.List;

public interface MeasurementService {
    List<Measurement> getMeasurement();
    void addNewMeasurement(Measurement measurement);
}
