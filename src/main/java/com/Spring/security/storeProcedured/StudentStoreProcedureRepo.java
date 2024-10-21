package com.Spring.security.storeProcedured;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.Spring.security.Model.People;

import jakarta.transaction.Transactional;

public interface StudentStoreProcedureRepo extends JpaRepository<People, String>{
	@Procedure
	List<People> getAllPeople();
	
	@Procedure(procedureName = "getAllPeople")
	List<People> getpeople();
	
	@Procedure(procedureName = "getByFirstName")
	People getByName(String fname);


}
