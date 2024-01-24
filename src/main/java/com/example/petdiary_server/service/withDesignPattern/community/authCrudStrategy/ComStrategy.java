package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy;

import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ComStrategy<T> {
    protected UserRepository userRepository;
    protected NoteRepository noteRepository;
    protected ScreenRepository screenRepository;

    public abstract T operate();
}
