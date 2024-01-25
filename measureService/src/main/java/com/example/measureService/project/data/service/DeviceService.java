package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.Device;
import com.example.measureService.project.data.dto.DeviceCreateRequest;

import java.util.List;

public interface DeviceService {
    List<Device> getDevices();
    void addNewDevice(DeviceCreateRequest deviceCreateRequest);
}
