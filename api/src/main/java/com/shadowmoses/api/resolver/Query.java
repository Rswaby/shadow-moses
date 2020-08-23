package com.shadowmoses.api.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shadowmoses.api.model.User;
import com.shadowmoses.api.service.UserService;
import com.shadowmoses.api.stockapi.AlphaVantageAPIClient;
import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
@Slf4j
public class Query implements GraphQLQueryResolver {
    private final UserService userService;

    @Autowired
    public Query(UserService userService){
        this.userService = userService;
    }

    public Iterable<User> getUsers(DataFetchingEnvironment environment) throws IllegalAccessException {
        log.info("====================== GET ALL USERS ======================");
        log.info("Authorizing User");
        AlphaVantageAPIClient.getMonthlyAdjusted("IBM");
        String token = getRequest(environment).getHeader("authorization").split(" ")[1];
        Optional<User> validatedUser = userService.validateUserToken(token);
        if (validatedUser.isPresent()){
            log.info("User Authorized");
            return userService.getAllUsers();
        }
        log.info("User cannot be Authorized");
        throw new GraphQLException("Invalid Token");
    }

    private HttpServletRequest getRequest(DataFetchingEnvironment env){
        GraphQLContext context = env.getContext();
        return context.getHttpServletRequest().get();
    }

    public long countUsers(){
        return userService.countUsers();
    }

}
