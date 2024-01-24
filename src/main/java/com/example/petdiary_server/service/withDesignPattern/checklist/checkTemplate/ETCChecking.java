package com.example.petdiary_server.service.withDesignPattern.checklist.checkTemplate;

import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;

public class ETCChecking extends AbstChecking{
    public ETCChecking(UserRepository userRepository, TodoCheckOfDateRepository todoCheckOfDateRepository) {
        super(userRepository, todoCheckOfDateRepository);
    }

    @Override
    protected UserTodoInfoWrapper tcodCheck(TodoCheckOfDate targetTodoCheckOfDate) {
        return targetTodoCheckOfDate == null ?
                new UserTodoInfoWrapper(false, "사용자가 작성한 게시글 내역을 못찾았어유", null, null) :
                new UserTodoInfoWrapper(true, "tcod확인 완료유", null, null);
    }
}
