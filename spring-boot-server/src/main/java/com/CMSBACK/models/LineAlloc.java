package com.CMSBACK.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
public class LineAlloc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @ManyToOne
    @JoinColumn(name = "line_id")
    Line line;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    
    User user;

    LocalDateTime allocatedAt;
}
