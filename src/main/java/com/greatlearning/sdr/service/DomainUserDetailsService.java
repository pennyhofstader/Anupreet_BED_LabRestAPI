package com.greatlearning.sdr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.sdr.entity.DomainUserDetails;
import com.greatlearning.sdr.repo.UserRepo;

@Service
public class DomainUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepo.findByUsername(username).map(DomainUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("bad credentials"));
	}

}
