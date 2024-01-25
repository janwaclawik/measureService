package com.example.measureService.project.data.controller;

import com.example.measureService.project.data.domain.DeviceType;
import com.example.measureService.project.data.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/device-mode")
public class DeviceTypeController {
    private final DeviceTypeService deviceTypeService;

    @Autowired
    public DeviceTypeController(DeviceTypeService deviceService, DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    @GetMapping("/device-type")
    public List<DeviceType> getDevType() {
        return deviceTypeService.getDevType();
    }

    @PostMapping
    public void registerNewDeviceType(@RequestBody DeviceType deviceType) {
        deviceTypeService.addNewDevType(deviceType);
    }
}
