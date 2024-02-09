package com.example.measureService.project.data.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MachineCreateRequest {
    private String machineModel;
    private String machineBrand;
    private String machineFirmware;

}
