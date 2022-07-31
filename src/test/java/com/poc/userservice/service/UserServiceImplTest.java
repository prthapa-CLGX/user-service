package com.poc.userservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.userservice.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void shouldGetJobTitleForAUser() {
        User.Key userKey = new User.Key();
        userKey.setUserId(1);
        userKey.setName("Alex Robinson");
        User user = userService.getUserById(userKey);

        assertThat(user.getJob()).isEqualTo("CEO");
    }
}