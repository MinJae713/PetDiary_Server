package com.example.petdiary_server.repository;

import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.community.Note;
import com.example.petdiary_server.entity.community.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, String> {
    public Optional<List<Note>> findAllByScreen(Screen screen);
}
