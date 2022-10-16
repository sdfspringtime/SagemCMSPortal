package com.CMSBACK.models;

import java.util.Date;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(	name = "machines")
@Audited
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Machine {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)

	private EMType typemach;

	private String description;
	private boolean allocated=false;
	private boolean status=false;
	private boolean FESE;
	 @JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="line_id")
    private Line line;
	
	
	@OneToMany(mappedBy = "machine")
    Set<MachineAlloc> machineallocs;
    private String revisionauthor;
	private Date revisiondate;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRevisionauthor() {
		return revisionauthor;
	}
	public void setRevisionauthor(String revisionauthor) {
		this.revisionauthor = revisionauthor;
	}
	public Date getRevisiondate() {
		return revisiondate;
	}
	public void setRevisiondate(Date revisiondate) {
		this.revisiondate = revisiondate;
	}
	public Long getId() {
		return id;

	}
	public void setId(Long id) {
		this.id = id;
	}
	public EMType getTypemach() {
		return typemach;
	}
	public void setTypemach(EMType typemach) {
		this.typemach = typemach;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAllocated() {
		return allocated;
	}
	public void setAllocated(boolean allocated) {
		this.allocated = allocated;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isFESE() {
		return FESE;
	}
	public void setFESE(boolean fESE) {
		FESE = fESE;
	}
	public Machine() {
		super();
	}

	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public Machine(EMType typemach, String description, boolean allocated, boolean status, boolean fESE, Line line,
			String revisionauthor, Date revisiondate, String name) {
		super();
		this.typemach = typemach;
		this.description = description;
		this.allocated = allocated;
		this.status = status;
		FESE = fESE;
		this.line = line;
		this.revisionauthor = revisionauthor;
		this.revisiondate = revisiondate;
		this.name = name;
	}
	
	
}
