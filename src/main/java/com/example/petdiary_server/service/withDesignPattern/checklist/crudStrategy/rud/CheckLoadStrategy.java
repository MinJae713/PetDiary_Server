package com.example.petdiary_server.service.withDesignPattern.checklist.crudStrategy.rud;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.TodoCheckRepository;
import com.example.petdiary_server.repository.UserRepository;

import java.util.List;

public class CheckLoadStrategy extends CheckRUDStrategy{
    public CheckLoadStrategy(
            UserRepository userRepository,
            TodoCheckOfDateRepository todoCheckOfDateRepository,
            TodoCheckRepository todoCheckRepository,
            String userId, String writeDate) {
        super(userRepository, todoCheckOfDateRepository, todoCheckRepository, userId, writeDate);
    }

    @Override
    public ResStatus<List<TodoCheckRes>> crudCheckList(String message) {
        return super.crudCheckList(message);
    }
}
