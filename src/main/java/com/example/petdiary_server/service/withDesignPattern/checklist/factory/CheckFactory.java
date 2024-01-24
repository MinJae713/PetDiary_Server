package com.example.petdiary_server.service.withDesignPattern.checklist.factory;

import com.example.petdiary_server.dto.checklist.req.AddTodoCheckReq;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.CheckCRUDStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CheckFactory {
    // 추상 팩토리 패턴 적용(다른 인스턴스 반환 시 새로 구현해서 사용)
    protected UserRepository userRepository;
    protected TodoCheckOfDateRepository todoCheckOfDateRepository;
    protected TodoCheckRepository todoCheckRepository;

    public abstract CheckCRUDStrategy createAddStrategy(AddTodoCheckReq addTodoCheckReq);
    public abstract CheckCRUDStrategy createDeleteStrategy(String todoId, String userId, String writeDate);
    public abstract CheckCRUDStrategy createToggleStrategy(String todoId, String userId, String writeDate);
    public abstract CheckCRUDStrategy createLoadStrategy(String userId, String writeDate);
}
