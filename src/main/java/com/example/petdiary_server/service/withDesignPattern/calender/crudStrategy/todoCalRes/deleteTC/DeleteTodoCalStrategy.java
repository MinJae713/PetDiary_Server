package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.deleteTC;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.calender.res.TodoCalRes;
import com.example.petdiary_server.entity.calender.TodoCal;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;

public class DeleteTodoCalStrategy extends CalTCdeleteTCStrategy{
    public DeleteTodoCalStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository, String id) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository, id);
    }

    @Override
    public ResStatus<TodoCalRes> crudCal(String successMessage) {
        TodoCal target = todoCalRepository.findById(id).orElse(null);
        if (target == null) return new ResStatus<TodoCalRes>(false, "해당 할 일을 못 찾았습니다.", null);
        todoCalRepository.delete(target);
        TodoCalRes result = target.createTodoCalRes();
        return new ResStatus<TodoCalRes>(true, successMessage, result);
    }
}
