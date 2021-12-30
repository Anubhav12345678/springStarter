package com.springStarter.demo.repository;

import com.springStarter.demo.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    
}