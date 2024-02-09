package com.example.measureService.project.data.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DeviceCreateRequest {
    private String deviceName;
    private UUID machineSerial;
    private Boolean breakMode;
    private Boolean waterFlow;
    private Boolean notifications;

}
