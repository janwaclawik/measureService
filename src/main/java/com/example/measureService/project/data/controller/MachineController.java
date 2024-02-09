package com.example.measureService.project.data.controller;

import com.example.measureService.project.data.domain.Machine;
import com.example.measureService.project.data.dto.MachineCreateRequest;
import com.example.measureService.project.data.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/machine")
public class MachineController {
    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping("/machine-type")
    public List<Machine> getMachine() {
        return machineService.getMachine();
    }

    @PostMapping
    public UUID registerNewMachine(@RequestBody MachineCreateRequest machineCreateRequest) {
        return machineService.addNewMachine(machineCreateRequest);
    }
}
