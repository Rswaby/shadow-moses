package com.shadowmoses.api.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.shadowmoses.api.model.Auth.AuthData;
import com.shadowmoses.api.model.Auth.SignInPayload;
import com.shadowmoses.api.model.User;
import com.shadowmoses.api.service.UserService;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
@Slf4j
public class Mutation implements GraphQLMutationResolver {
    private final UserService userService;

    @Autowired
    public Mutation(UserService userService) {
        this.userService = userService;
    }

    public User registerUser(final String name, final String email, final String password){
        return userService.registerUser(name, email, password);
    }

    public SignInPayload signIn(final AuthData authData, DataFetchingEnvironment env) throws IllegalAccessException {
        GraphQLContext context = env.getContext();
        HttpServletRequest httpServletRequest = context.getHttpServletRequest().get();
        log.info(httpServletRequest.getHeader("authorization"));
        //don't really need this here but cool. thanks
        return userService.signIn(authData);
    }

}

