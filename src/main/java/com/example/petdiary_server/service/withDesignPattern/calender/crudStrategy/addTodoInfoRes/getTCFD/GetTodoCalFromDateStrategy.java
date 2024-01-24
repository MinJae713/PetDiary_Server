package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.getTCFD;

import com.example.petdiary_server.dto.ResStatus;
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

public class GetTodoCalFromDateStrategy extends CalATIgetTCFDStrategy{
    public GetTodoCalFromDateStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            String dateId, String userId) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository, dateId, userId);
    }

    @Override
    public ResStatus<AllTodosInfoRes> crudCal(String successMessage) {
        User targetUser = userRepository.findById(userId).orElse(null);
        if (targetUser == null)
            return new ResStatus<AllTodosInfoRes>(false, "아이디에 맞는 사용자가 없어유", null);
        TodoCalOfDate targetTodoCalOfDate = todoCalOfDateRepository.findByUserAndDate(targetUser, dateId).orElse(null);
        if (targetTodoCalOfDate == null)
            return new ResStatus<AllTodosInfoRes>(false, "작성된 일, 선택된 기분이 아무것도 없어유", null);
        // --------------------------------------------------------------------------------------------
        List<TodoCal> targetTodoCals = todoCalRepository.findAllByTodoCalOfDate(targetTodoCalOfDate).orElse(null);
        AllTodosInfoRes result = null;
        List<TodoCalRes> todoCalRes = new ArrayList<TodoCalRes>();
        String message = "선택 기분은 있는디 작성된 일이 없어유";
        if (targetTodoCals != null) {
            for (TodoCal todoCal : targetTodoCals) todoCalRes.add(todoCal.createTodoCalRes());
            message = successMessage;
        }
        result = targetTodoCalOfDate.createAllTodosInfo(todoCalRes);
        return new ResStatus<AllTodosInfoRes>(true, message, result);
    }
}
