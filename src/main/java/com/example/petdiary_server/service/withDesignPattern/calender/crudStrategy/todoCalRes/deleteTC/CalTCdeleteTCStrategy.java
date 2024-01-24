package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.deleteTC;

import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.CalTCStrategy;

public abstract class CalTCdeleteTCStrategy extends CalTCStrategy {
    protected String id;
    public CalTCdeleteTCStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            String id) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
        this.id = id;
    }
}
