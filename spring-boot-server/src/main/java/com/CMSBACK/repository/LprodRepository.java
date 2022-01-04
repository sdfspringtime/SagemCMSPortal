package com.CMSBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMSBACK.models.Line;
import com.CMSBACK.models.User;

public interface LprodRepository extends JpaRepository<Line, Long>{

}
