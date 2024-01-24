package com.example.petdiary_server.service.withDesignPattern.calender.factory;

import com.example.petdiary_server.dto.calender.req.AddTodoCalReq;
import com.example.petdiary_server.dto.calender.req.EditTodoCalReq;
import com.example.petdiary_server.dto.calender.req.TodosCalOfDateReq;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.CalStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CalenderFactory {
    // 추상 팩토리 패턴 적용(다른 인스턴스 반환 시 새로 구현해서 사용)
    protected UserRepository userRepository;
    protected TodoCalOfDateRepository todoCalOfDateRepository;
    protected TodoCalRepository todoCalRepository;

    public abstract CalStrategy createAddTCStrategy(AddTodoCalReq addTodoCalReq);
    public abstract CalStrategy createGetTCFDStrategy(String dateId, String userId);
    public abstract CalStrategy createAddTCODStrategy(TodosCalOfDateReq reqData);
    public abstract CalStrategy createEditFeelStrategy(TodosCalOfDateReq reqData);
    public abstract CalStrategy createEditTCStrategy(EditTodoCalReq editTodoCalReq);
    public abstract CalStrategy createDeleteTCStrategy(String id);
}
