package com.shadowmoses.api.repository;

import com.shadowmoses.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    User findUserByEmail(String email);
}
