package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.Machine;
import com.example.measureService.project.data.dto.MachineCreateRequest;
import com.example.measureService.project.data.repository.DeviceRepository;
import com.example.measureService.project.data.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;
    private final DeviceRepository deviceRepository;

    public MachineServiceImpl(MachineRepository machineRepository, DeviceRepository deviceRepository) {
        this.machineRepository = machineRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Machine> getMachine() {
        return machineRepository.findAll();
    }


    @Override
    public UUID addNewMachine(MachineCreateRequest machineCreateRequest) {
        if(machineRepository.findMachineByMachineBrand(machineCreateRequest.getMachineBrand()).isPresent()){
            throw new IllegalStateException("Brand taken");
        }
        Machine machine = machineRepository.save(Machine.buildMachine(machineCreateRequest));
        machineRepository.save(machine);
        return machine.getMachineSerial();
//        Device device = deviceRepository.findById(machineCreateRequest.getSerial()).orElseThrow(IllegalStateException::new);
//        machine.
    }
}
