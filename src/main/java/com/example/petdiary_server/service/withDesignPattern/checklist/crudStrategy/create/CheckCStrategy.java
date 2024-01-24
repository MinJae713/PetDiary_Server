package com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.create;

import com.example.petdiary_server.dto.checklist.req.AddTodoCheckReq;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.checkTemplate.AddChecking;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.CheckCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;

public abstract class CheckCStrategy extends CheckCRUDStrategy {
    protected AddTodoCheckReq addTodoCheckReq;
    public CheckCStrategy(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository,
            AddTodoCheckReq addTodoCheckReq) {
        super(userRepository, todoCheckOfDateRepository, todoCheckRepository);
        this.addTodoCheckReq = addTodoCheckReq;
    }
    @Override
    protected UserTodoInfoWrapper checkUserAndWriteDate(String userId, String writeDate) {
        tcodCheckTemplate = new AddChecking(userRepository, todoCheckOfDateRepository);
        return super.checkUserAndWriteDate(userId, writeDate);
    }
}
