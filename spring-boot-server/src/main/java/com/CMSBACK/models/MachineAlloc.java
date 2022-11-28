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
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Audited
public class MachineAlloc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @ManyToOne
    @JoinColumn(name = "machine_id")
    Machine machine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    LocalDateTime allocatedAt;

}
