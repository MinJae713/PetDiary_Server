package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.editTC;

import com.example.petdiary_server.dto.calender.req.EditTodoCalReq;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.CalTCStrategy;

public abstract class CalTCeditTCStrategy extends CalTCStrategy {
    protected EditTodoCalReq editTodoCalReq;
    public CalTCeditTCStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            EditTodoCalReq editTodoCalReq) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
        this.editTodoCalReq = editTodoCalReq;
    }
}
