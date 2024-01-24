package com.example.petdiary_server.service.withDesignPattern.calender.factory;

import com.example.petdiary_server.dto.calender.req.AddTodoCalReq;
import com.example.petdiary_server.dto.calender.req.EditTodoCalReq;
import com.example.petdiary_server.dto.calender.req.TodosCalOfDateReq;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.CalStrategy;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.addTC.AddTodoCalStrategy;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.addTodoInfoRes.getTCFD.GetTodoCalFromDateStrategy;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalOfDateRes.cu.AddTodoCalOfDateStrategy;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalOfDateRes.cu.EditFeelIdxStrategy;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.deleteTC.DeleteTodoCalStrategy;
import com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.editTC.EditTodoCal;

public class CalenderTodoCalFactory extends CalenderFactory{
    public CalenderTodoCalFactory(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository);
    }
    @Override
    public CalStrategy createAddTCStrategy(AddTodoCalReq addTodoCalReq) {
        return new AddTodoCalStrategy(
                userRepository, todoCalOfDateRepository,
                todoCalRepository, addTodoCalReq);
    }
    @Override
    public CalStrategy createGetTCFDStrategy(String dateId, String userId) {
        return new GetTodoCalFromDateStrategy(
                userRepository, todoCalOfDateRepository,
                todoCalRepository, dateId, userId);
    }
    @Override
    public CalStrategy createAddTCODStrategy(TodosCalOfDateReq reqData) {
        return new AddTodoCalOfDateStrategy(
                userRepository, todoCalOfDateRepository,
                todoCalRepository, reqData);
    }
    @Override
    public CalStrategy createEditFeelStrategy(TodosCalOfDateReq reqData) {
        return new EditFeelIdxStrategy(
                userRepository, todoCalOfDateRepository,
                todoCalRepository, reqData);
    }
    @Override
    public CalStrategy createEditTCStrategy(EditTodoCalReq editTodoCalReq) {
        return new EditTodoCal(
                userRepository, todoCalOfDateRepository,
                todoCalRepository, editTodoCalReq);
    }
    @Override
    public CalStrategy createDeleteTCStrategy(String id) {
        return new DeleteTodoCalStrategy(
                userRepository, todoCalOfDateRepository,
                todoCalRepository, id);
    }
}
