package com.Spring.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.security.Model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long>{
	Optional<MyUser> findByUsername(String name);

}
