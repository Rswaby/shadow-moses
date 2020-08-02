package com.shadowmoses.api.service;

import com.shadowmoses.api.model.Auth.AuthData;
import com.shadowmoses.api.model.Auth.SignInPayload;
import com.shadowmoses.api.model.User;
import com.shadowmoses.api.repository.UserRepository;
import graphql.GraphQLException;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(final String name, final String email, final String password) {
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
        userRepository.save(user);
        return user;
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public long countUsers(){
        return userRepository.count();
    }

    public User getUserByEmail(final String email){
        log.info("Looking up Email: "+email);
        return userRepository.findUserByEmail(email);
    }
    public SignInPayload signIn(AuthData authData) throws IllegalAccessException{
        System.out.println("SIGNIN USER");
        log.debug("User Login");
        log.debug(authData.toString());
        User user = getUserByEmail(authData.getEmail());
        throw new GraphQLException("Invalid Credentials:  " + user);
    }

    public User convertToUserObj(Document doc){
        if (doc == null){
            return null;
        }
        User user = User.builder()
                .id(doc.get("_id").toString())
                .name(doc.getString("name"))
                .email(doc.getString("email"))
                .password(doc.getString("password"))
                .build();
        log.info("returning User: " + user.toString());
        return user;
    }
}
