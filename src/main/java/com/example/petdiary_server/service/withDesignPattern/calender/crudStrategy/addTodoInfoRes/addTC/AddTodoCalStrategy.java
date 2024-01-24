package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.addTC;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.calender.req.AddTodoCalReq;
import com.example.petdiary_server.dto.calender.res.AllTodosInfoRes;
import com.example.petdiary_server.dto.calender.res.TodoCalRes;
import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.calender.TodoCal;
import com.example.petdiary_server.entity.calender.TodoCalOfDate;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class AddTodoCalStrategy extends CalATIaddTCStrategy{
    public AddTodoCalStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            AddTodoCalReq addTodoCalReq) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository, addTodoCalReq);
    }

    @Override
    public ResStatus<AllTodosInfoRes> crudCal(String successMessage) {
        User targetUser = userRepository.findById(addTodoCalReq.getUserId()).orElse(null);
        if (targetUser == null)
            return new ResStatus<AllTodosInfoRes>(false, "아이디에 맞는 사용자가 없어유", null);
        TodoCalOfDate targetTodoCalOfDate =
                todoCalOfDateRepository.findByUserAndDate(targetUser, addTodoCalReq.getDateId()).orElse(null);
        if (targetTodoCalOfDate == null)
            return new ResStatus<AllTodosInfoRes>(false, "작성된 일, 선택된 기분이 아무것도 없어유", null);
        // --------------------------------------------------------------------------------------------
        TodoCal alreadyTodo = todoCalRepository.findById(addTodoCalReq.getId()).orElse(null);
        if (alreadyTodo != null)
            return new ResStatus<AllTodosInfoRes>(false, "이미 입력된 아이디가 있구먼유", null);
        TodoCal newTodo = new TodoCal(addTodoCalReq.getId(), addTodoCalReq.getText(), targetTodoCalOfDate);
        TodoCal saveResult = todoCalRepository.save(newTodo);
        if (saveResult == null) return new ResStatus<AllTodosInfoRes>(false, "저장이 안되었어유", null);
        // 반환 준비
        List<TodoCal> targetTodoCals = todoCalRepository.findAllByTodoCalOfDate(targetTodoCalOfDate).orElse(null);
        List<TodoCalRes> todoCalRes = new ArrayList<TodoCalRes>();
        for (TodoCal todoCal : targetTodoCals) todoCalRes.add(todoCal.createTodoCalRes());
        AllTodosInfoRes result = targetTodoCalOfDate.createAllTodosInfo(todoCalRes);
        return new ResStatus<AllTodosInfoRes>(true, successMessage, result);
    }
}
