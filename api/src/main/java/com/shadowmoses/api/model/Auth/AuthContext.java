package com.shadowmoses.api.model.Auth;


import graphql.servlet.GraphQLContext;
import org.springframework.stereotype.Component;


@Component
public class AuthContext extends GraphQLContext {
    public static final String BEARER_PREFIX = "Bearer ";
}
