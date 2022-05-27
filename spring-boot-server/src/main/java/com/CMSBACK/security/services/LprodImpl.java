package com.CMSBACK.security.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Import;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.CMSBACK.repository.LprodRepository;
@Service
public class LprodImpl {
    @PersistenceContext // or even @Autowired
    private EntityManager entityManager;
    public List<Object[]> getAudits(long id){
    return entityManager.createNativeQuery("SELECT rev,revtype,description,name,revisiondate,revisionauthor FROM lines_p_aud WHERE id="+id+" ORDER BY revisiondate").getResultList();
    
    }
}
