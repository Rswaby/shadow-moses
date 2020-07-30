package com.shadowmoses.api.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.shadowmoses.api.model.Auth.AuthData;
import com.shadowmoses.api.model.Auth.SignInPayload;
import com.shadowmoses.api.model.User;
import com.shadowmoses.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Mutation implements GraphQLMutationResolver {
    private final UserService userService;

    @Autowired
    public Mutation(UserService userService) {
        this.userService = userService;
    }

    public User registerUser(final String name, final String email, final String password){
        return userService.registerUser(name, email, password);
    }

    public SignInPayload signIn(final AuthData authData) throws IllegalAccessException {
        return userService.signIn(authData);
    }


}

