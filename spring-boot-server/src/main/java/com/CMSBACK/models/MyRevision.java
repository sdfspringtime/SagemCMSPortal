package com.CMSBACK.models;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.*;
import org.hibernate.envers.RevisionEntity;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}