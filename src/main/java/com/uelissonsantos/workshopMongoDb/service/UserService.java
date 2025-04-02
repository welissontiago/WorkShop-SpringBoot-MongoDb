package com.uelissonsantos.workshopMongoDb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uelissonsantos.workshopMongoDb.domain.User;
import com.uelissonsantos.workshopMongoDb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

}
