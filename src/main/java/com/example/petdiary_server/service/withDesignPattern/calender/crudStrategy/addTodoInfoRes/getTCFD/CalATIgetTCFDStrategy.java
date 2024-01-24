package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.getTCFD;

import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.CalATIStrategy;

public abstract class CalATIgetTCFDStrategy extends CalATIStrategy {
    protected String dateId;
    protected String userId;
    public CalATIgetTCFDStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            String dateId, String userId) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
        this.dateId = dateId;
        this.userId = userId;
    }
}
