package com.example.measureService.project.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID serialModel;

    @OneToOne(mappedBy = "deviceModel") // Odniesienie do klasy Device
    @JsonIgnore
    private Device devTypes;

    private String deviceModelName;
    private String deviceBrand;
    private String deviceFirmwareVersion;

}
