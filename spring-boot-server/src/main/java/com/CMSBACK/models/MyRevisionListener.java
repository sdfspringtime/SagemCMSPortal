package com.CMSBACK.models;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.envers.*;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
 @Service
public class MyRevisionListener implements RevisionListener, EntityTrackingRevisionListener {
	/* @PersistenceContext
	    private EntityManager entityManager;
	    public AuditReader getAuditReader() {
	        return  AuditReaderFactory.get(  this.entityManager);
	    }
*/
	    public String getUserName() {
	    	final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	String username=authentication.getName();
	    	return username;
	    }
    @Override
    public void newRevision(Object revisionEntity) {
    	 
    	   final SecurityContext context = SecurityContextHolder.getContext();
           MyRevision audit = (MyRevision) revisionEntity;
          
           /*AuditReader reader = getAuditReader();
           Line emp=reader.findRevision(Line.class, audit.getId());
           Object obj= ContextLookup.getCurrentEntity();*/
          
           if (context != null) {

               if (context.getAuthentication() != null) {
                     audit.setUser(context.getAuthentication().getName());
            	   /*if( Line.class.isInstance(obj)) {
                	   audit.setIsline(true);
                   }*/
               } else {

            	   audit.setUser( "anonymous");
            	   

               }
               
            
           

           }
           }
  /*  @PersistenceContext
    private EntityManager entityManager;
    public List<Line> getLignRevisionList(Long id) {
    	
 	   final AuditReader auditReader = AuditReaderFactory.get(entityManager);
 	   AuditQuery q = auditReader.createQuery().forRevisionsOfEntity(Line.class, true, true);
 	   q.add(AuditEntity.id().eq(id));
 	   List<Line> audit = q.getResultList();
 	   return q.getResultList();
    }*/

	@Override
	public void entityChanged(Class entityClass, String entityName, Serializable entityId, RevisionType revisionType,
			Object revisionEntity) {
		// TODO Auto-generated method stub
		
	}}
