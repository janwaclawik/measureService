package com.example.measureService.project.data.domain;

import com.example.measureService.project.data.dto.DeviceCreateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Device")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID serial;
    private String deviceName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "DeviceType",
            joinColumns = @JoinColumn(name = "deviceModel"),
            inverseJoinColumns = @JoinColumn(name = "serialModel")
    )
    private DeviceType deviceModel;


    private Boolean breakMode;
    private Boolean waterFlow;
    private Boolean notifications;

    @ManyToMany(mappedBy = "devices")
    private List<UserAccount> userAccounts = new ArrayList<>();

    //lista pomiarów
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Measurement",
            joinColumns = @JoinColumn(name = "measure"),
            inverseJoinColumns = @JoinColumn(name = "measureList")
    )
    private List<Measurement> measure = new ArrayList<>();



    public static Device buildDevice(DeviceCreateRequest deviceCreateRequest) {
        return Device.builder()
                .deviceName(deviceCreateRequest.getDeviceName())
                .breakMode(deviceCreateRequest.getBreakMode())
                .waterFlow(deviceCreateRequest.getWaterFlow())
                .notifications(deviceCreateRequest.getNotifications())
                .build();
    }

}
