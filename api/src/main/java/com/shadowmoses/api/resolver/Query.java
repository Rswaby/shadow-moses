package com.shadowmoses.api.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shadowmoses.api.model.User;
import com.shadowmoses.api.repository.UserRepository;
import com.shadowmoses.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final UserService userService;

    @Autowired
    public Query(UserService userService){
        this.userService = userService;
    }

    public Iterable<User> getUsers(){
        return userService.getAllUsers();
    }

    public long countUsers(){
        return userService.countUsers();
    }

}
