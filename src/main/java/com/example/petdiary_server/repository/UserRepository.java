package com.example.petdiary_server.repository;

import com.example.petdiary_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
}
