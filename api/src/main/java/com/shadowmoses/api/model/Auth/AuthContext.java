package com.shadowmoses.api.model.Auth;

import com.shadowmoses.api.model.User;
import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLContextBuilder;
import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.HandshakeRequest;
import java.util.Optional;

@Component
public class AuthContext implements GraphQLContextBuilder {
    @Override
    public GraphQLContext build(HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public GraphQLContext build(HandshakeRequest handshakeRequest) {
        return null;
    }

    @Override
    public GraphQLContext build() {
        return null;
    }
    
}
