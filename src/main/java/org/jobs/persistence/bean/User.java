/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jobs.persistence.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author vit
 */
@Entity
@Table(name = "users")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
        
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "name", unique = false)
	private String name;
	@Column(name = "login", unique = true)
	private String login;
	@Column(name = "pass")
	private String pass;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "GROUP_ID")
	private Group group;
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "project_user")
	private Set<Project> projects = new HashSet<Project>();

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	@XmlTransient
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@XmlTransient
	public Set<Project> getProjects() {
		return projects;
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