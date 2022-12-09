package com.CMSBACK.controllers;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.CMSBACK.models.MyRevisionListener;
import com.CMSBACK.models.Role;
import com.CMSBACK.models.User;
import com.CMSBACK.repository.LprodRepository;
import com.CMSBACK.repository.RoleRepository;
import com.CMSBACK.repository.UserRepository;
import com.CMSBACK.security.services.LprodImpl;
import com.CMSBACK.security.services.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/users") 
public class UserController {

	
	
	
	
	 private String username;
        @Autowired
        PasswordEncoder encoder;
	    @Autowired
	    private UserRepository linerep;
	    @Autowired
	    private RoleRepository Rrep;
	    @Autowired
	    MyRevisionListener rl;
	 

        
		@PostMapping("/add")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LMANAGER')")
		public User addLProd(@RequestBody User lignep) {

			lignep.setRevisionauthor(SecurityContextHolder.getContext().getAuthentication().getName());
			Date date = new Date();
			/*Set<String> ruser=new HashSet<>();
			ruser=(Set<String>)lignep.getRoles();
			Set<Role> roles = new HashSet<>();

			for (Role role : lignep.getRoles())
			
				roles.add(Rrep.findById(role.getId()).get());
				
			*/
	         lignep.setPassword(encoder.encode(lignep.getPassword()));

			lignep.setRevisiondate(date);
            
            
			 return linerep.save(lignep);

			  }

		
		@GetMapping("/getall")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LMANAGER')")
		public List<User> getAllLp() {
			
			return linerep.findAll();
		}
		@GetMapping("/getRoles/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LMANAGER')")
		public Set<Role> getAllRoles(@PathVariable(value = "id") Long id) {
			
			return linerep.findById(id).get().getRoles();
		}
		@GetMapping("/getRoles1")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LMANAGER')")
		public List<Role> getAllRoles1() {
			
			return Rrep.findAll();
		}
		@Autowired 
		UserDetailsServiceImpl lpi;
		@GetMapping("/getaudit/{id}")
		@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LMANAGER')")
			public List<Object[]> getLineRevisions(@PathVariable(value = "id")Long id)
			{
			
		return lpi.getAudits(id);}
			
			/*@GetMapping("/getrolebyname/{name}")
			@PreAuthorize("hasRole('ROLE_ADMIN')")
	
			 
			public Role getRoleByname(@PathVariable(value = "name") String name) {
				return 
							}*/
			

	@GetMapping("/getById/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LMANAGER')")
	public User getlpById(@PathVariable(value = "id") Long id) {


		Optional<User> optionalEntity =  linerep.findById(id);
		 User line = optionalEntity.get();
	return line;
	}
	@DeleteMapping("/delete/{id}")
	public void deleteline(@PathVariable(value = "id") Long lineid) {
		Optional<User> aaa=linerep.findById(lineid);
		aaa.get().setRevisionauthor(SecurityContextHolder.getContext().getAuthentication().getName());

		Date date = new Date(); 

		linerep.findById(lineid).get().setRevisiondate(date);

	    linerep.deleteById(lineid);


	}
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ROLE_LMANAGER') or hasRole('ROLE_ADMIN')")
		public void updatelp(@PathVariable(value = "id") Long id,
		          @RequestBody User userdetails) {
	        User user = linerep.findById(id).get();
	        user.setEmail(userdetails.getEmail());
	        user.setPassword(encoder.encode(user.getPassword()));
	        user.setRoles(userdetails.getRoles());
	        user.setUsername(userdetails.getUsername());
	    	Optional<User> aaa=linerep.findById(id);
	        
	         	   

	    	aaa.get().setRevisionauthor(SecurityContextHolder.getContext().getAuthentication().getName());
	            
	    	Date date = new Date();  

	    	linerep.findById(id).get().setRevisiondate(date);
	        linerep.save(user);

		
	}
	}
