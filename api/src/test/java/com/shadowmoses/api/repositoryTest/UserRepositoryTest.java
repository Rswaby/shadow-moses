package com.shadowmoses.api.repositoryTest;

import com.shadowmoses.api.model.User;
import com.shadowmoses.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {UserRepository.class})
@SpringBootTest
public class UserRepositoryTest {
    @MockBean
    private UserRepository mockRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByEmailTest(){
        String filterEmail = "test"+System.currentTimeMillis()+"@shadow.com";
        System.out.println(filterEmail);
        User user = User.builder()
                .email(filterEmail)
                .name("TestUser")
                .password("secret")
                .build();

        userRepository.save(user);
        User userResult = userRepository.findUserByEmail(filterEmail);

        Mockito.when(mockRepository.findUserByEmail(filterEmail)).thenReturn(user);

        Mockito.verify(mockRepository).findUserByEmail(filterEmail);
//        assertEquals(userResult,user);

    }
}
