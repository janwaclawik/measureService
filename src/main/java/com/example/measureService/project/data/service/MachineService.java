package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.Machine;
import com.example.measureService.project.data.dto.MachineCreateRequest;

import java.util.List;
import java.util.UUID;

public interface MachineService {
    List<Machine> getMachine();

    UUID addNewMachine(MachineCreateRequest machineCreateRequest);
}
