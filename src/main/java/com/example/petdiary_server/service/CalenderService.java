package com.example.petdiary_server.service;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.calender.req.AddTodoCalReq;
import com.example.petdiary_server.dto.calender.req.TodosCalOfDateReq;
import com.example.petdiary_server.dto.calender.req.EditTodoCalReq;
import com.example.petdiary_server.dto.calender.res.*;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.CalStrategy;
import com.example.petdiary_server.service.withDesignPattern.calender.factory.CalenderFactory;
import com.example.petdiary_server.service.withDesignPattern.calender.factory.CalenderTodoCalFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalenderService {
    private CalStrategy calStrategy;
    private CalenderFactory factory;

    @Autowired
    public CalenderService(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository) {
        this.factory = new CalenderTodoCalFactory(userRepository, todoCalOfDateRepository, todoCalRepository);
        // 추상 팩토리 - 다른 Strategy들 반환하고 싶으면 클래스 새로 구현해서 여기만 바꾸면 됨(아래 메소드들 바꿀 필요 없음)
    }

    public ResStatus<AllTodosInfoRes> addTodoCal(AddTodoCalReq addTodoCalReq) {
        calStrategy = factory.createAddTCStrategy(addTodoCalReq);
        return calStrategy.crudCal("저장 성공이어유!");
    }
    public ResStatus<AllTodosInfoRes> getTodoCalFromDate(String dateId, String userId) {
        calStrategy = factory.createGetTCFDStrategy(dateId, userId);
        return calStrategy.crudCal("조회 성공이어유!");
    }
    public ResStatus<TodosCalOfDateRes> addTodosCalOfDate(TodosCalOfDateReq reqData) {
        calStrategy = factory.createAddTCODStrategy(reqData);
        return calStrategy.crudCal("저장 성공이어유!");
    }
    public ResStatus<TodosCalOfDateRes> editFeelIdx(TodosCalOfDateReq reqData) {
        calStrategy = factory.createEditFeelStrategy(reqData);
        return calStrategy.crudCal("수정 성공이어유!");
    }
    public ResStatus<TodoCalRes> editTodoCal(EditTodoCalReq editTodoCalReq) {
        calStrategy = factory.createEditTCStrategy(editTodoCalReq);
        return calStrategy.crudCal("수정 성공이어유!");
    }
    public ResStatus<TodoCalRes> deleteTodoCal(String id) {
        calStrategy = factory.createDeleteTCStrategy(id);
        return calStrategy.crudCal("삭제 성공이어유!");
    }
}
