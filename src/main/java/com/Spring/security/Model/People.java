package com.Spring.security.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class People {
	String email;
	String last_name;
	String first_name;
	String organization_code;
	String roles;
	String middle_name;
	@Id
	String person_id;
	
	
	
	
	
	public People() {
		super();
	}
	public People(String email, String last_name, String first_name, String organization_code, String roles,
			String middle_name, String person_id) {
		super();
		this.email = email;
		this.last_name = last_name;
		this.first_name = first_name;
		this.organization_code = organization_code;
		this.roles = roles;
		this.middle_name = middle_name;
		this.person_id = person_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getOrganization_code() {
		return organization_code;
	}
	public void setOrganization_code(String organization_code) {
		this.organization_code = organization_code;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	@Override
	public String toString() {
		return "People [email=" + email + ", last_name=" + last_name + ", first_name=" + first_name
				+ ", organization_code=" + organization_code + ", roles=" + roles + ", middle_name=" + middle_name
				+ ", person_id=" + person_id + "]";
	}
	
	
	

	
	
}
