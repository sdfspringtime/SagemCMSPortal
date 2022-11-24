package com.CMSBACK.controllers;

import java.security.Principal;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBACK.models.Line;
import com.CMSBACK.models.MyRevision;
import com.CMSBACK.models.MyRevisionListener;
import com.CMSBACK.models.User;
import com.CMSBACK.repository.LprodRepository;
import com.CMSBACK.security.services.LprodImpl;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/LigneProd") 
public class LigneProdController {
	   private String username;

    @Autowired
    private LprodRepository linerep;
    
    @Autowired
    MyRevisionListener rl;
 


	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
	public Line addLProd(@RequestBody Line lignep) {

		lignep.setrevisionauthor(SecurityContextHolder.getContext().getAuthentication().getName());
		Date date = new Date(); 

		lignep.setrevisiondate(date);

		 return linerep.save(lignep);

		  }

	
	@GetMapping("/getall")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
	public List<Line> getAllLp() {
		
		return linerep.findAll();
	}
	@Autowired 
	LprodImpl lpi;
	@GetMapping("/getaudit/{id}")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
		public List<Object[]> getLineRevisions(@PathVariable(value = "id")Long id)
		{
		
	return lpi.getAudits(id);}
		
	

@GetMapping("/getById/{id}")
@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
public Line getlpById(@PathVariable(value = "id") Long id) {


	Optional<Line> optionalEntity =  linerep.findById(id);
	 Line line = optionalEntity.get();
return line;
}
@DeleteMapping("/delete/{id}")
public void deleteline(@PathVariable(value = "id") Long lineid) {
	Optional<Line> aaa=linerep.findById(lineid);
	aaa.get().setrevisionauthor(SecurityContextHolder.getContext().getAuthentication().getName());

	Date date = new Date(); 

	linerep.findById(lineid).get().setrevisiondate(date);

    linerep.deleteById(lineid);


}
@PutMapping("/update/{id}")
@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
	public void updatelp(@PathVariable(value = "id") Long id,
	          @RequestBody Line linedetails) {
        Line line = linerep.findById(id).get();
        line.setDescription(linedetails.getDescription());
        
        line.setName(linedetails.getName());
    	Optional<Line> aaa=linerep.findById(id);
        
         	   

    	aaa.get().setrevisionauthor(SecurityContextHolder.getContext().getAuthentication().getName());
            
    	Date date = new Date();  

    	linerep.findById(id).get().setrevisiondate(date);
        linerep.save(line);

	
}
}
