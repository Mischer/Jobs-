/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jobs.persistence.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

/**
 * 
 * @author vit
 */
@Entity
@Table(name = "users")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "username", unique = false, nullable = false)
	private String username;
	@Column(name = "pass", nullable = false)
	private String password;
	@Column(name = "enabled")
	private boolean enabled;
	@Column(name = "accountExpired")
	private Date accountExpired;
	@Column(name = "credentialsExpired")
	private Date credentialsExpired;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return getAccountExpired().after(new Date());
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return getCredentialsExpired().after(new Date());
	}

	public Date getAccountExpired() {
    	return accountExpired;
    }

	public void setAccountExpired(Date accountExpired) {
    	this.accountExpired = accountExpired;
    }

	public Date getCredentialsExpired() {
    	return credentialsExpired;
    }

	public void setCredentialsExpired(Date credentialsExpired) {
    	this.credentialsExpired = credentialsExpired;
    }

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	@Transient
	public GrantedAuthority[] getAuthorities() {
		return roles.toArray(new Role[roles.size()]);
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.jobs.persistence.bean.Users[id=" + id + "]";
	}
}