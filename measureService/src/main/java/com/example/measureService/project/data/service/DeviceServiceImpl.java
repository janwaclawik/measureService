package com.example.measureService.project.data.service;

import com.example.measureService.project.data.domain.Device;
import com.example.measureService.project.data.domain.DeviceType;
import com.example.measureService.project.data.dto.DeviceCreateRequest;
import com.example.measureService.project.data.repository.DeviceRepository;
import com.example.measureService.project.data.repository.DeviceTypeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final DeviceTypeRepository deviceTypeRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, DeviceTypeRepository deviceTypeRepository) {
        this.deviceRepository = deviceRepository;
        this.deviceTypeRepository = deviceTypeRepository;
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
        DeviceType deviceType = deviceTypeRepository.findById(deviceCreateRequest.getDeviceModelId()).orElseThrow(IllegalStateException::new);
        device.setDeviceModel(deviceType);
        deviceRepository.save(device);

//        Device device1 = deviceRepository.save(deviceCreateRequest);
//        DeviceType deviceType = deviceTypeRepository.save(deviceCreateRequest.getDeviceModel());
//        device1.setDeviceModel(deviceType);
//        deviceRepository.save(device1);
    }
}
