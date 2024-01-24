package com.example.petdiary_server.repository;

import com.example.petdiary_server.entity.community.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen, String> {
    public Optional<Screen> findByTitle(String title);
    public Optional<List<Screen>> findAllByType(String type);
}
