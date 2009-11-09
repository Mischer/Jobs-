package org.jobs.web;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

public class LoginService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException, DataAccessException {
		UserDetails details = new UserDetailsImpl();
		return details;
	}

}
