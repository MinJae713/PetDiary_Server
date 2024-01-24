package com.example.petdiary_server.repository;

import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoCheckOfDateRepository extends JpaRepository<TodoCheckOfDate, Long>{
    public Optional<TodoCheckOfDate> findByUserAndWriteDate(User user, String writeDate);
}
