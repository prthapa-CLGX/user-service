package com.poc.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, User.Key> {

    Optional<User> findById(User.Key id);

}
