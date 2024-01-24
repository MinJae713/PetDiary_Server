package com.example.petdiary_server.service.withDesignPattern.checklist.factory;

import com.example.petdiary_server.dto.checklist.req.AddTodoCheckReq;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.CheckCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.create.CheckAddStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.CheckLoadStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.togdel.CheckDeleteStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.togdel.CheckToggleStrategy;

public class CheckTodosFactory extends CheckFactory {
    public CheckTodosFactory(UserRepository userRepository,
                             TodoCheckOfDateRepository todoCheckOfDateRepository,
                             TodoCheckRepository todoCheckRepository) {
        super(userRepository, todoCheckOfDateRepository, todoCheckRepository);
    }

    public CheckCRUDStrategy createAddStrategy(AddTodoCheckReq addTodoCheckReq) {
        return new CheckAddStrategy(
                userRepository,
                todoCheckOfDateRepository,
                todoCheckRepository,
                addTodoCheckReq);
    }
    public CheckCRUDStrategy createDeleteStrategy(String todoId, String userId, String writeDate) {
        return new CheckDeleteStrategy(
                userRepository,
                todoCheckOfDateRepository,
                todoCheckRepository,
                userId, writeDate, todoId);
    }
    public CheckCRUDStrategy createToggleStrategy(String todoId, String userId, String writeDate) {
        return new CheckToggleStrategy(
                userRepository,
                todoCheckOfDateRepository,
                todoCheckRepository,
                userId, writeDate, todoId);
    }
    public CheckCRUDStrategy createLoadStrategy(String userId, String writeDate) {
        return new CheckLoadStrategy(
                userRepository,
                todoCheckOfDateRepository,
                todoCheckRepository,
                userId, writeDate);
    }
}
