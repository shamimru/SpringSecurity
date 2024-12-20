package com.Spring.security.storeProcedured;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.security.Model.People;

import jakarta.transaction.Transactional;

@Service
public class StoreProceduredService {
	@Autowired
	public StudentStoreProcedureRepo studentStoreProcedureRepo;

    @Transactional

	public List<People> getAllPeopleFromdb() {
		return studentStoreProcedureRepo.getAllPeople();
	}
	
    @Transactional
	public List<People> getAllPeopleFromdb2() {
		return studentStoreProcedureRepo.getpeople();
	}
    
    @Transactional
  	public People getByFName(String fname) {
  		return studentStoreProcedureRepo.getByName(fname);
  	}
    
    @Transactional
  	public Map<String, Object> get3Values(String personId) {
  		return studentStoreProcedureRepo.get3Values(personId);
  	}
	
	
}
