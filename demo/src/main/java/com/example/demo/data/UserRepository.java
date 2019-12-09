package com.example.demo.data;

import java.util.List;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}