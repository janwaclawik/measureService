package com.example.measureService.project.data.controller;

import com.example.measureService.project.data.domain.Measurement;
import com.example.measureService.project.data.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/measure")
public class MeasurementController {
    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<Measurement> getMeasure() {
        return measurementService.getMeasurement();
    }

    @PostMapping
    public void registerNewMeasure(@RequestBody Measurement measurement) {
        measurementService.addNewMeasurement(measurement);
    }
}
