package com.shadowmoses.api.model.Auth;

import com.shadowmoses.api.model.User;
import graphql.servlet.GraphQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

//@Component
public class AuthContext extends GraphQLContext {
//    @Autowired
    private final User user;

    public AuthContext (User user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response){
//        super(request);
        this.user = user;

    }
}
