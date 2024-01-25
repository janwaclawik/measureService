package com.example.measureService.project.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID measurementId;

    //data
    //jednostka
    //tablice z wartościami
    private Integer water;

    @ManyToMany(mappedBy = "measure")
    private List<Device> measureList = new ArrayList<>();

}
