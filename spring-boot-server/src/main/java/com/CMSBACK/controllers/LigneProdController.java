package com.CMSBACK.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CMSBACK.models.Line;
import com.CMSBACK.repository.LprodRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/LigneProd") 
public class LigneProdController {
    @Autowired
    private LprodRepository linerep;

	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
	public Line addLProd(@RequestBody Line lignep) {
		 return linerep.save(lignep);

		  }
		
		
	
	@GetMapping("/getall")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
	public List<Line> getAllLp() {
		
		return linerep.findAll();
	}
	

@GetMapping("/getById/{id}")
@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
public Line getlpById(@PathVariable(value = "id") Long id) {


	Optional<Line> optionalEntity =  linerep.findById(id);
	 Line line = optionalEntity.get();
return line;
}

@PutMapping("/update/{id}")
@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
	public void updatelp(@PathVariable(value = "id") Long id,
	          @RequestBody Line linedetails) {
        Line line = linerep.findById(id).get();
        line.setDescription(linedetails.getDescription());
        line.setName(linedetails.getName());
        linerep.save(line);

	
}
}
