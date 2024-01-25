package com.example.measureService.project.data.controller;

import com.example.measureService.project.data.domain.Device;
import com.example.measureService.project.data.dto.DeviceCreateRequest;
import com.example.measureService.project.data.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/device")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }

    @PostMapping
    public void registerNewDevice(@RequestBody DeviceCreateRequest deviceCreateRequest){
        deviceService.addNewDevice(deviceCreateRequest);
    }
}
