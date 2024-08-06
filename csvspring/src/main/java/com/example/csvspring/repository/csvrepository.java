package com.example.csvspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.csvspring.entity.User;
@Repository

public interface csvrepository extends MongoRepository<User, Long> {

}
