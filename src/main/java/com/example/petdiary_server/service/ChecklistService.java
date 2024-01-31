package com.example.petdiary_server.service;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.checklist.req.AddTodoCheckReq;
import com.example.petdiary_server.dto.checklist.req.NewTask;
import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import com.example.petdiary_server.entity.checklist.TodoCheck;
import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.CheckCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.create.CheckAddStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.CheckLoadStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.togdel.CheckDeleteStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.togdel.CheckToggleStrategy;
import com.example.petdiary_server.service.withDesignPattern.checklist.factory.CheckFactory;
import com.example.petdiary_server.service.withDesignPattern.checklist.factory.CheckTodosFactory;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChecklistService {
    private CheckCRUDStrategy crudStrategy;
    private CheckFactory factory;


    @Autowired
    public ChecklistService(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository) {
        this.factory = new CheckTodosFactory(userRepository, todoCheckOfDateRepository, todoCheckRepository);
        // 추상 팩토리 - 다른 Strategy들 반환하고 싶으면 클래스 새로 구현해서 여기만 바꾸면 됨(아래 메소드들 바꿀 필요 없음)
    }

    public ResStatus<List<TodoCheckRes>> addTodoCheck(AddTodoCheckReq addTodoCheckReq) {
        crudStrategy = factory.createAddStrategy(addTodoCheckReq);
        return crudStrategy.crudCheckList("저장 성공입니다!");
    }
    public ResStatus<List<TodoCheckRes>> deleteTodoCheck(String todoId, String userId, String writeDate) {
        crudStrategy = factory.createDeleteStrategy(todoId, userId, writeDate);
        return crudStrategy.crudCheckList("삭제 성공입니다!");
    }
    public ResStatus<List<TodoCheckRes>> toggleTodoCheck(String todoId, String userId, String writeDate) {
        crudStrategy = factory.createToggleStrategy(todoId, userId, writeDate);
        return crudStrategy.crudCheckList("토글 성공입니다!");
    }
    public ResStatus<List<TodoCheckRes>> loadTodosCheck(String userId, String writeDate) {
        crudStrategy = factory.createLoadStrategy(userId, writeDate);
        return crudStrategy.crudCheckList("조회 성공입니다!");
    }
}
