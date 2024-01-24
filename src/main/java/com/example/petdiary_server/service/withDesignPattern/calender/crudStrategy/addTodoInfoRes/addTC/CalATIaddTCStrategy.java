package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.addTC;

import com.example.petdiary_server.dto.calender.req.AddTodoCalReq;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.CalATIStrategy;

public abstract class CalATIaddTCStrategy extends CalATIStrategy {
    protected AddTodoCalReq addTodoCalReq;
    public CalATIaddTCStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            AddTodoCalReq addTodoCalReq) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
        this.addTodoCalReq = addTodoCalReq;
    }
}
