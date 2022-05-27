package com.CMSBACK.models;

import java.util.Date;
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

@Entity
@Table(name = "lines_p")
@Audited
public class Line {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "line",cascade = CascadeType.ALL, orphanRemoval = true)
    Set<LineAlloc> lineallocs;
	private String description;
    private String revisionauthor;
	
	private Date revisiondate;
	
	
	
	public Set<LineAlloc> getLineallocs() {
		return lineallocs;
	}
	public void setLineallocs(Set<LineAlloc> lineallocs) {
		this.lineallocs = lineallocs;
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
