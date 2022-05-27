package com.CMSBACK.models;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.envers.*;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "my_revision")
@RevisionEntity(MyRevisionListener.class)
public class MyRevision extends DefaultRevisionEntity {
 
    @Column(name = "user")
    private String user;
    @Column(name = "isline")
    private boolean isline;
    @Column(name = "ismachine")
    private boolean ismachine;
    @Column(name = "isuser")
    private boolean isuser;



        

        	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isIsline() {
		return isline;
	}

	public void setIsline(boolean isline) {
		this.isline = isline;
	}

	public boolean isIsmachine() {
		return ismachine;
	}

	public void setIsmachine(boolean ismachine) {
		this.ismachine = ismachine;
	}

	public boolean isIsuser() {
		return isuser;
	}

	public void setIsuser(boolean isuser) {
		this.isuser = isuser;
	}
	
}
