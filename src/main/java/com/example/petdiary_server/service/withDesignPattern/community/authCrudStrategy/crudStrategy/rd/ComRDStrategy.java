package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.rd;

import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.ComCRUDStrategy;

public abstract class ComRDStrategy extends ComCRUDStrategy {
    protected String userId;
    protected String param;
    public ComRDStrategy(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository,
            String userId, String param) {
        super(userRepository, noteRepository, screenRepository);
        this.userId = userId;
        this.param = param;
    }
}
