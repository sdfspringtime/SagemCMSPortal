package com.CMSBACK.models;

import org.hibernate.envers.RevisionListener;

import java.util.Optional;

import org.hibernate.envers.*;
import org.hibernate.envers.RevisionEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class MyRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        MyRevision audit = (MyRevision) revisionEntity;
        audit.setUser(currentUser);

	 }}
