package com.example.measureService.project.data.domain;

import com.example.measureService.project.data.dto.MachineCreateRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID machineSerial;

    @OneToOne(mappedBy = "machineModel") // Odniesienie do klasy Device
    private Device devTypes;

    private String machineModel;
    private String machineBrand;
    private String machineFirmware;

    public static Machine buildMachine(MachineCreateRequest machineCreateRequest) {
        return Machine.builder()
                .machineModel(machineCreateRequest.getMachineModel())
                .machineBrand(machineCreateRequest.getMachineBrand())
                .machineFirmware(machineCreateRequest.getMachineFirmware())
                .build();
    }

}
