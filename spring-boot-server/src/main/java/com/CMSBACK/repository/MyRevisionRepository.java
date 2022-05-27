package com.CMSBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMSBACK.models.Line;
import com.CMSBACK.models.MyRevision;

public interface MyRevisionRepository  extends JpaRepository<MyRevision, Long>{

}
