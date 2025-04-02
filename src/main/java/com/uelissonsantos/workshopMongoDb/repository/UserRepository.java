package com.uelissonsantos.workshopMongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uelissonsantos.workshopMongoDb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
