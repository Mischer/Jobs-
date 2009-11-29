package org.jobs.persistence.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	@Column(name="firstName")
    private String firstName;
	@Column(name="lastName", nullable=false)
    private String lastName;
	@Column(name="middleName")
    private String middleName;
	@Column(name="address", nullable=false)
    private String address;
    @Temporal(TemporalType.DATE)
    @Column(name="birthday")
    private Date birthday;
    
    public Client() {
    }
    
	public Long getId() {
    	return id;
    }

	public void setId(Long id) {
    	this.id = id;
    }

	public String getFirstName() {
    	return firstName;
    }

	public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

	public String getLastName() {
    	return lastName;
    }

	public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

	public String getMiddleName() {
    	return middleName;
    }

	public void setMiddleName(String middleName) {
    	this.middleName = middleName;
    }

	public String getAddress() {
    	return address;
    }

	public void setAddress(String address) {
    	this.address = address;
    }

	public Date getBirthday() {
    	return birthday;
    }

	public void setBirthday(Date birthday) {
    	this.birthday = birthday;
    }
    
}
