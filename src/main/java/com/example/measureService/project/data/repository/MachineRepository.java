package com.example.measureService.project.data.repository;

import com.example.measureService.project.data.domain.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MachineRepository extends JpaRepository<Machine, UUID> {
    Optional<Machine> findMachineByMachineBrand(String machineBrand);

}
