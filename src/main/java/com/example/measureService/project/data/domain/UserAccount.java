package com.example.measureService.project.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String email;
    //@JsonIgnore
    //private String password;
    private String name;
    private String surname;

    @ManyToMany
    @JoinTable(
            name = "Device",
            joinColumns = @JoinColumn(name = "user_account_userId"),
            inverseJoinColumns = @JoinColumn(name = "device_deviceId")
    )
    private List<Device> devices = new ArrayList<>();

}
