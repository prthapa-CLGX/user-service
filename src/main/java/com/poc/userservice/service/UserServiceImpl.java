package com.poc.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.userservice.model.User;
import com.poc.userservice.repository.UserRepository;
import com.sun.istack.NotNull;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(User.Key key) {
        Optional<User> user = userRepository.findById(key);
        if(user.isPresent()) {
            return user.get();
        }
        log.info("User not found. Returning empty user");
        return emptyUser();
    }

    public User emptyUser() {
        return new User();
    }

}
