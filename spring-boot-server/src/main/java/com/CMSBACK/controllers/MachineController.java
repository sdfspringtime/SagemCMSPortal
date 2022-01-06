package com.CMSBACK.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.CMSBACK.models.Machine;
import com.CMSBACK.repository.LprodRepository;
import com.CMSBACK.repository.MachineRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Machines")
public class MachineController {


	 @Autowired
	    private MachineRepository machrep;

		@PostMapping("/add")
		@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
		public Machine addLProd(@RequestBody Machine machine) {
			
			 return machrep.save(machine);

			  }
			
			
		
		@GetMapping("/getall")
		@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
		public List<Machine> getAllLp() {
			
			return machrep.findAll();
		}
		

	@GetMapping("/getById/{id}")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_MACHINIST')")
	public Machine getlpById(@PathVariable(value = "id") Long id) {


	return	machrep.findById(id).get();
	
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
		public void updatelp(@PathVariable(value = "id") Long id,
		          @RequestBody Machine machinedetails) {
	        Machine mach = machrep.findById(id).get();
	        mach.setDescription(machinedetails.getDescription());
	        mach.setTypemach(machinedetails.getTypemach());
	        mach.setAllocated(machinedetails.isAllocated());
	        mach.setFESE(machinedetails.isFESE());
	        mach.setLine(machinedetails.getLine());
	        machrep.save(machinedetails);

		
	}
}
