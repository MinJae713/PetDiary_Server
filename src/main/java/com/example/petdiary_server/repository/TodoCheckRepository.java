package com.example.petdiary_server.repository;

import com.example.petdiary_server.entity.checklist.TodoCheck;
import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoCheckRepository extends JpaRepository<TodoCheck, String>{
    public Optional<List<TodoCheck>> findAllByTodoCheckOfDate(TodoCheckOfDate todoCheckOfDate);
}
