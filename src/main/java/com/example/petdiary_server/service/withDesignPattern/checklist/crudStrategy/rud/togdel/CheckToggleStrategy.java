package com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud.togdel;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import com.example.petdiary_server.entity.checklist.TodoCheck;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;

import java.util.List;

public class CheckToggleStrategy extends CheckUDStrategy{
    public CheckToggleStrategy(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository,
            String userId, String writeDate, String todoId) {
        super(userRepository, todoCheckOfDateRepository, todoCheckRepository, userId, writeDate, todoId);
    }

    @Override
    public ResStatus<List<TodoCheckRes>> crudCheckList(String message) {
        TodoCheck target = todoCheckRepository.findById(todoId).orElse(null);
        if (target == null)
            return new ResStatus<List<TodoCheckRes>>(false, "아이디에 맞는 할 일이 없습니다.", null);
        target.setChecked(!target.isChecked());
        todoCheckRepository.save(target);
        return super.crudCheckList(message);
    }
}
