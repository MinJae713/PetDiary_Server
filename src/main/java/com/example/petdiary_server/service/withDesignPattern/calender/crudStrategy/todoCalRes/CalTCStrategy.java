package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes;

import com.example.petdiary_server.dto.calender.res.TodoCalRes;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.CalStrategy;

public abstract class CalTCStrategy extends CalStrategy<TodoCalRes> {
    public CalTCStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
    }
}
