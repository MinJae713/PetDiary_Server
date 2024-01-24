package com.example.petdiary_server.repository;

import com.example.petdiary_server.entity.calender.TodoCalOfDate;
import com.example.petdiary_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoCalOfDateRepository extends JpaRepository<TodoCalOfDate, Long> {
    public Optional<TodoCalOfDate> findByUserAndDate(User user, String date);
}
