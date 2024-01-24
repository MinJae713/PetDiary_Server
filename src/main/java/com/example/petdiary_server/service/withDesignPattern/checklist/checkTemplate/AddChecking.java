package com.example.petdiary_server.service.withDesignPattern.checklist.checkTemplate;

import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;

public class AddChecking extends AbstChecking{

    public AddChecking(UserRepository userRepository, TodoCheckOfDateRepository todoCheckOfDateRepository) {
        super(userRepository, todoCheckOfDateRepository);
    }

    @Override
    protected UserTodoInfoWrapper tcodCheck(TodoCheckOfDate targetTodoCheckOfDate) {
        return new UserTodoInfoWrapper(true, "tcod확인 완료유", null, null);
    }
}
