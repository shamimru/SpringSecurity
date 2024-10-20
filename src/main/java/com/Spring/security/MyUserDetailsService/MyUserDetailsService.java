package com.Spring.security.MyUserDetailsService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Spring.security.Model.MyUser;
import com.Spring.security.repository.MyUserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired 
	MyUserRepository myUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<MyUser> user = myUserRepository.findByUsername(username);
		
		if(user.isPresent()) {
			var userObj=user.get();
			System.out.println(userObj.getRole());

			return User.builder()
					.username(userObj.getUsername())
					.password(userObj.getPassword())
					.roles(getRoles(userObj))
					.build();
			
			
		}else {
			System.out.println("user not found "+username);
			throw new UsernameNotFoundException("user not Found with = "+username);
		}
	}
	
	public String[] getRoles(MyUser user) {
		if(user.getRole() == null) {
			return new String [] {"USER"};
		}
		return user.getRole().split(",");
		
	}

}
