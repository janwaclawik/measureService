package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.DeviceType;

import java.util.List;

public interface DeviceTypeService {
    List<DeviceType> getDevType();
    void addNewDevType(DeviceType deviceType);
}
