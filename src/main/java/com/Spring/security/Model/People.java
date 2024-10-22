package com.Spring.security.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NamedStoredProcedureQuery(
		name="findOnly3Variable",
		procedureName = "get3Values",
		parameters = {
				@StoredProcedureParameter(
						mode=ParameterMode.IN,
						name = "id", 
						type = String.class
						),
				@StoredProcedureParameter(
						mode=ParameterMode.OUT,
						name = "emaill", 
						type = String.class
						),
				@StoredProcedureParameter(
						mode=ParameterMode.OUT,
						name = "firstname", 
						type = String.class
						),
				@StoredProcedureParameter(
						mode=ParameterMode.OUT,
						name = "lastname", 
						type = String.class
						)
				
		})

@Data
@NoArgsConstructor
public class People {
	String email;
	String last_name;
	String first_name;
	String organization_code;
	String roles;
	String middle_name;
	@Id
	String person_id;
	
	
	
	


	
	
}
