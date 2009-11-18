package org.jobs.web;

import java.io.Serializable;

import org.jobs.persistence.bean.RoleConstant;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;

public class RoleBean implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
	public boolean isROLE_ADMINISTRATOR(){
		for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
			if (authority.getAuthority().equals(RoleConstant.ROLE_ADMINISTRATOR)){
				return true;
			}
		}
		return false;
	}

	
	public boolean isROLE_USER(){
		for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
			if (authority.getAuthority().equals(RoleConstant.ROLE_USER)){
				return true;
			}
		}
		return false;
	}

}
