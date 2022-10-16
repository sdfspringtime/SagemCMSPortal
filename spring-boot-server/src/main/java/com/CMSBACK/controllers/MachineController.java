package com.CMSBACK.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.CMSBACK.models.Machine;
import com.CMSBACK.models.MyRevisionListener;
import com.CMSBACK.repository.LprodRepository;
import com.CMSBACK.repository.MachineRepository;
import com.CMSBACK.security.services.LprodImpl;
import com.CMSBACK.security.services.MachineImpl;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Machines")
public class MachineController {


	 @Autowired
	    private MachineRepository machrep;

	 @Autowired
	    MyRevisionListener rl;
	 
		@PostMapping("/add")
		
		public Machine addmachine(@RequestBody Machine machine) {
			machine.setRevisionauthor(rl.getUserName());
			Date date = new Date(); 
           machine.setRevisiondate(date);
			 return machrep.save(machine);

			  }
			
		@Autowired 
		MachineImpl lpi;
		@GetMapping("/getaudit/{id}")

			public List<Object[]> getMachinesRevisions(@PathVariable(value = "id")Long id)
			{
			
		return lpi.getMachinesRevisions(id);}
		
		@GetMapping("/getall")
		public List<Machine> getAllmachines() {
			
			return machrep.findAll();
		}
		

	@GetMapping("/getById/{id}")

	public Machine getmachineById(@PathVariable(value = "id") Long id) {


	return	machrep.findById(id).get();
	
	}

	@PutMapping("/update/{id}")
		public void updatemachine(@PathVariable(value = "id") Long id,
		          @RequestBody Machine machinedetails) {
	        Machine mach = machrep.findById(id).get();
	        mach.setDescription(machinedetails.getDescription());
	        mach.setName(machinedetails.getName());
	        mach.setTypemach(machinedetails.getTypemach());
	        mach.setAllocated(machinedetails.isAllocated());
	        mach.setFESE(machinedetails.isFESE());
	        mach.setLine(machinedetails.getLine());
	        machrep.save(machinedetails);

		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteline(@PathVariable(value = "id") Long id) {
		Optional<Machine> aaa=machrep.findById(id);
		aaa.get().setRevisionauthor(rl.getUserName());

		Date date = new Date(); 

		machrep.findById(id).get().setRevisiondate(date);

	    machrep.deleteById(id);

	}
}
