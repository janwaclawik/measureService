package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.Device;
import com.example.measureService.project.data.domain.Machine;
import com.example.measureService.project.data.dto.DeviceCreateRequest;
import com.example.measureService.project.data.repository.DeviceRepository;
import com.example.measureService.project.data.repository.MachineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final MachineRepository machineRepository;
    
    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, MachineRepository machineRepository) {
        this.deviceRepository = deviceRepository;
        this.machineRepository = machineRepository;
    }

    @Override
    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    @Override
    @Transactional
    public void addNewDevice(DeviceCreateRequest deviceCreateRequest) {
        if(deviceRepository.findDeviceByDeviceName(deviceCreateRequest.getDeviceName()).isPresent()) {
            throw new IllegalStateException("name taken");
        }
        Device device = deviceRepository.save(Device.buildDevice(deviceCreateRequest));
        Machine machine = machineRepository.findById(deviceCreateRequest.getMachineSerial()).
                orElseThrow(IllegalStateException::new);
        device.setMachineModel(machine);
        deviceRepository.save(device);


//        Device device1 = deviceRepository.save(deviceCreateRequest);
//        DeviceType deviceType = deviceTypeRepository.save(deviceCreateRequest.getDeviceModel());
//        device1.setDeviceModel(deviceType);
//        deviceRepository.save(device1);
    }
}
