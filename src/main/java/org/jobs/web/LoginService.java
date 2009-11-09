package org.jobs.web;

import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

public class LoginService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String name)	throws UsernameNotFoundException, DataAccessException {
		UserDetails details = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return true;
			}
			
			@Override
			public String getUsername() {
				return "test";
			}
			
			@Override
			public String getPassword() {
				return "test";
			}
			
			@Override
			public GrantedAuthority[] getAuthorities() {
				GrantedAuthority[] authorities = new GrantedAuthorityImpl[1]; 
				authorities[0] = new  GrantedAuthorityImpl("ROLE_USER"); 
				return authorities;
			}
		};
		return details;
	}

}
