package com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.create;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.checklist.req.AddTodoCheckReq;
import com.example.petdiary_server.dto.checklist.req.NewTask;
import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.checklist.TodoCheck;
import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;

import java.util.List;

public class CheckAddStrategy extends CheckCStrategy{
    public CheckAddStrategy(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository,
            AddTodoCheckReq addTodoCheckReq) {
        super(userRepository, todoCheckOfDateRepository, todoCheckRepository, addTodoCheckReq);
    }

    @Override
    public ResStatus<List<TodoCheckRes>> crudCheckList(String message) {
        NewTask newTask = addTodoCheckReq.getNewTask();
        String userId = addTodoCheckReq.getUserId();
        UserTodoInfoWrapper checkResult = checkUserAndWriteDate(userId, newTask.getWriteDate());
        if (!checkResult.isSuccess())
            return new ResStatus<List<TodoCheckRes>>(false, checkResult.getMessage(), null);
        User targetUser = checkResult.getUser();
        TodoCheckOfDate targetTodoCheckOfDate = checkResult.getTodoCheckOfDate();
        if (targetTodoCheckOfDate == null) {
            TodoCheckOfDate newTodoCheckOfDate = new TodoCheckOfDate(null, newTask.getWriteDate(), targetUser);
            targetTodoCheckOfDate = todoCheckOfDateRepository.save(newTodoCheckOfDate);
        }
        TodoCheck todoCheck = new TodoCheck(
                newTask.getId(),
                newTask.getTextValue(),
                newTask.isChecked(),
                targetTodoCheckOfDate
        );
        TodoCheck saveResult = todoCheckRepository.save(todoCheck);
        if (saveResult == null) return new ResStatus<List<TodoCheckRes>>(false, "저장 실패입니다.", null);
        return getTodoChecks(message, targetTodoCheckOfDate);
    }
}
