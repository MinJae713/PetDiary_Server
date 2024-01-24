package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy.todoCalOfDateRes.cu;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.calender.req.TodosCalOfDateReq;
import com.example.petdiary_server.dto.calender.res.TodosCalOfDateRes;
import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.calender.TodoCalOfDate;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;

public class AddTodoCalOfDateStrategy extends CalTCODCUStrategy{
    public AddTodoCalOfDateStrategy(
            UserRepository userRepository,
            TodoCalOfDateRepository todoCalOfDateRepository,
            TodoCalRepository todoCalRepository,
            TodosCalOfDateReq reqData) {
        super(userRepository, todoCalOfDateRepository, todoCalRepository, reqData);
    }

    @Override
    public ResStatus<TodosCalOfDateRes> crudCal(String successMessage) {
        User targetUser = userRepository.findById(reqData.getUserId()).orElse(null);
        if (targetUser == null)
            return new ResStatus<TodosCalOfDateRes>(false, "아이디에 맞는 사용자가 없어유", null);
        TodoCalOfDate targetTodoCalOfDate =
                new TodoCalOfDate(null, reqData.getDateId(), reqData.getFeelIdx(), targetUser);
        TodoCalOfDate saveResult = todoCalOfDateRepository.save(targetTodoCalOfDate);
        if (saveResult == null) return new ResStatus<TodosCalOfDateRes>(false, "저장이 안되었어유", null);
        TodosCalOfDateRes result = saveResult.createTodoCalDate();
        return new ResStatus<TodosCalOfDateRes>(true, successMessage, result);
    }
}
