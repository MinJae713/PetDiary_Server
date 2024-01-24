package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes;

import com.example.petdiary_server.dto.calender.res.AllTodosInfoRes;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.CalStrategy;

public abstract class CalATIStrategy extends CalStrategy<AllTodosInfoRes> {
    public CalATIStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
    }
}
