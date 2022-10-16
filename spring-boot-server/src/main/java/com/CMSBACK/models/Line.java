package com.CMSBACK.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "lines_p")
@Audited
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Line {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @JsonBackReference
     @OneToMany(mappedBy = "line",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Machine> lines=new HashSet<>();
	private String description;
    private String revisionauthor;
	
	private Date revisiondate;
	
	
	

	public Set<Machine> getLines() {
		return lines;
	}
	public void setLines(Set<Machine> lines) {
		this.lines = lines;
	}
	

	public String getrevisionauthor() {
		return revisionauthor;
	}
	public void setrevisionauthor(String createdby) {
		this.revisionauthor = createdby;
	}
	public Date getrevisiondate() {
		return revisiondate;
	}
	public void setrevisiondate(Date creationdate) {
		this.revisiondate = creationdate;
	}
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
