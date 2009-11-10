package org.jobs.persistence.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "authority")
	private String authority;

	//@ManyToMany(mappedBy = "roles")
	//private Set<User> users = new HashSet<User>();
	enum{
		
	}

	public Role() {
	}

	public Role(String authority) {
		this.authority = authority;
	}
	
	public Long getId() {
    	return id;
    }

	public void setId(Long id) {
    	this.id = id;
    }

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	//public void setUsers(Set<User> users) {
	//	this.users = users;
	//}

	//public Set<User> getUsers() {
	//	return users;
	//}

	@Override
	public int compareTo(Object o) {
		if (o != null && o instanceof GrantedAuthority) {
			String rhsRole = ((GrantedAuthority) o).getAuthority();

			if (rhsRole == null) {
				return -1;
			}

			return authority.compareTo(rhsRole);
		}
		return -1;
	}

}
