package com.CMSBACK.security.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CMSBACK.models.User;
import com.CMSBACK.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
    @PersistenceContext // or even @Autowired
    private EntityManager entityManager;
    public List<Object[]> getAudits(long id){
    return entityManager.createNativeQuery("SELECT r.name,u1.email,u1.username,u1.revtype,u1.revisionauthor,u1.revisiondate FROM users_aud u1 LEFT JOIN user_roles u ON u.user_id=u1.id LEFT JOIN roles r ON r.id=u.role_id WHERE u1.id= "+id+" ORDER BY revisiondate").getResultList();
    
    }
}
