package com.CMSBACK.security.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
@Service
public class MachineImpl{
	@PersistenceContext // or even @Autowired
    private EntityManager entityManager;
    public List<Object[]> getMachinesRevisions(long id){
    return entityManager.createNativeQuery("SELECT rev,revtype,name,description,fese,typemach,status,line_id,revisiondate,revisionauthor FROM machines_aud WHERE id="+id+" ORDER BY revisiondate").getResultList();
    
    }
}
