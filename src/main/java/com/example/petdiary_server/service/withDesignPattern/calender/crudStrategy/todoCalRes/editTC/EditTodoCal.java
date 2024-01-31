package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalRes.editTC;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.calender.req.EditTodoCalReq;
import com.example.petdiary_server.dto.calender.res.TodoCalRes;
import com.example.petdiary_server.entity.calender.TodoCal;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;

public class EditTodoCal extends CalTCeditTCStrategy{
    public EditTodoCal(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            EditTodoCalReq editTodoCalReq) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository, editTodoCalReq);
    }

    @Override
    public ResStatus<TodoCalRes> crudCal(String successMessage) {
        TodoCal target = todoCalRepository.findById(editTodoCalReq.getId()).orElse(null);
        if (target == null) return new ResStatus<TodoCalRes>(false, "해당 할 일을 못 찾았습니다.", null);
        target.setText(editTodoCalReq.getText());
        TodoCal editResult = todoCalRepository.save(target);
        if (editResult == null) new ResStatus<TodoCalRes>(false, "수정이 안 되었습니다.", null);
        TodoCalRes result = editResult.createTodoCalRes();
        return new ResStatus<TodoCalRes>(true, successMessage, result);
    }
}
