package com.Spring.security.storeProcedured;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.Spring.security.Model.People;

public interface StudentStoreProcedureRepo extends JpaRepository<People, String>{
	@Procedure
	List<People> getAllPeople();
	
	@Procedure(procedureName = "getAllPeople")
	List<People> getpeople();
	
	@Procedure(procedureName = "getByFirstName")
	People getByName(String fname);
	
	@Procedure(name="findOnly3Variable")
	public List<Map<String, Object> >get3Values (String id);

}
