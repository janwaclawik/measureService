package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.DeviceType;
import com.example.measureService.project.data.repository.DeviceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService{
    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceTypeServiceImpl(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }

    @Override
    public List<DeviceType> getDevType() {
        return deviceTypeRepository.findAll();
    }

    @Override
    public void addNewDevType(DeviceType deviceType) {
        if(deviceTypeRepository.findDeviceTypeByDeviceBrand(deviceType.getDeviceBrand()).isPresent()){
            throw new IllegalStateException("Brand taken");
        } else {
            deviceTypeRepository.save(deviceType);
        }
    }
}
