package com.CMSBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMSBACK.models.Machine;
import com.CMSBACK.models.User;

public interface MachineRepository extends JpaRepository<Machine, Long> {

}
