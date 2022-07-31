package com.poc.userservice.service;

import com.poc.userservice.model.User;

public interface UserService {

    User getUserById(User.Key key);
}
