package com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.checkTemplate.ETCChecking;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.CheckCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;

import java.util.List;

public abstract class CheckRUDStrategy extends CheckCRUDStrategy {
    protected String userId;
    protected String writeDate;
    public CheckRUDStrategy(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository,
            String userId, String writeDate) {
        super(userRepository, todoCheckOfDateRepository, todoCheckRepository);
        this.userId = userId;
        this.writeDate = writeDate;
    }

    @Override
    protected UserTodoInfoWrapper checkUserAndWriteDate(String userId, String writeDate) {
        tcodCheckTemplate = new ETCChecking(userRepository, todoCheckOfDateRepository);
        return super.checkUserAndWriteDate(userId, writeDate);
    }

    @Override
    public ResStatus<List<TodoCheckRes>> crudCheckList(String message) {
        UserTodoInfoWrapper checkResult = checkUserAndWriteDate(userId, writeDate);
        if (!checkResult.isSuccess())
            return new ResStatus<List<TodoCheckRes>>(false, checkResult.getMessage(), null);
        TodoCheckOfDate targetTodoCheckOfDate = checkResult.getTodoCheckOfDate();
        return getTodoChecks(message, targetTodoCheckOfDate);
    }
}
