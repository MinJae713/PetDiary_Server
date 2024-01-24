package com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.togdel;

import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.CheckRUDStrategy;

public abstract class CheckUDStrategy extends CheckRUDStrategy {
    protected String todoId;
    public CheckUDStrategy(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository,
            String userId, String writeDate, String todoId) {
        super(userRepository, todoCheckOfDateRepository, todoCheckRepository, userId, writeDate);
        this.todoId = todoId;
    }
}
