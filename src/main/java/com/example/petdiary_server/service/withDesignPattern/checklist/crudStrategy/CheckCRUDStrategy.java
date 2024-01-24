package com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import com.example.petdiary_server.entity.checklist.TodoCheck;
import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.checkTemplate.AbstChecking;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;

import java.util.ArrayList;
import java.util.List;

public abstract class CheckCRUDStrategy {
    // 전략 패턴 사용 - SRP 만족(Checklist 기능 수행 ㄱㄴ, 파라미터가 추가로 필요하면 얘 상속해서 사용)
    protected UserRepository userRepository;
    protected TodoCheckOfDateRepository todoCheckOfDateRepository;
    protected TodoCheckRepository todoCheckRepository;
    protected AbstChecking tcodCheckTemplate;

    public CheckCRUDStrategy(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository) {
        this.userRepository = userRepository;
        this.todoCheckOfDateRepository = todoCheckOfDateRepository;
        this.todoCheckRepository = todoCheckRepository;
    }
    protected UserTodoInfoWrapper checkUserAndWriteDate(String userId, String writeDate) {
        return tcodCheckTemplate.checkUserAndWriteDate(userId, writeDate);
    }

    protected ResStatus<List<TodoCheckRes>> getTodoChecks(String message, TodoCheckOfDate targetTodoCheckOfDate) {
        List<TodoCheck> todoChecks = todoCheckRepository.findAllByTodoCheckOfDate(targetTodoCheckOfDate).orElse(null);
        if (todoChecks == null) return new ResStatus<List<TodoCheckRes>>(false, "할 일 내용을 하나도 못찾았어유", null);
        List<TodoCheckRes> result = new ArrayList<TodoCheckRes>();
        for (TodoCheck todo : todoChecks)
            result.add(todo.createTodoCheckRes());
        return new ResStatus<List<TodoCheckRes>>(true, message, result);
    }

    public abstract ResStatus<List<TodoCheckRes>> crudCheckList(String message);
}
