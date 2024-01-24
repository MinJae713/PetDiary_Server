package com.example.petdiary_server.repository;

import com.example.petdiary_server.entity.calender.TodoCal;
import com.example.petdiary_server.entity.calender.TodoCalOfDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoCalRepository extends JpaRepository<TodoCal, String>{
    public Optional<List<TodoCal>> findAllByTodoCalOfDate(TodoCalOfDate todoCalOfDate);
}
