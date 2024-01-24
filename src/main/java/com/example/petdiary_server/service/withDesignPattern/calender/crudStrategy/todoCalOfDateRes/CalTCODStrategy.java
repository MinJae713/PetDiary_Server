package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalOfDateRes;

import com.example.petdiary_server.dto.calender.res.TodosCalOfDateRes;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.CalStrategy;

public abstract class CalTCODStrategy extends CalStrategy<TodosCalOfDateRes> {
    public CalTCODStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
    }
}
