package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalOfDateRes.cu;

import com.example.petdiary_server.dto.calender.req.TodosCalOfDateReq;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalOfDateRes.CalTCODStrategy;

public abstract class CalTCODCUStrategy extends CalTCODStrategy {
    protected TodosCalOfDateReq reqData;
    public CalTCODCUStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            TodosCalOfDateReq reqData) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
        this.reqData = reqData;
    }
}
