package com.example.petdiary_server.service.withDesignPattern.checklist.checkTemplate;

import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import com.example.petdiary_server.repository.TodoCheckOfDateRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.checklist.wrapper.UserTodoInfoWrapper;

public abstract class AbstChecking {
    // 전략 패턴 사용 - SRP 만족(userId, 작성일에 따른 확인 작업 ㄱㄴ)
    // 템플릿 메소드 패턴 사용 (todoCheckOfDate를 확인하는 방식에 대한 추상화 - 하위 클래스에서 어떻게 확인하는지 구현)
    protected UserRepository userRepository;
    protected TodoCheckOfDateRepository todoCheckOfDateRepository;

    public AbstChecking(UserRepository userRepository, TodoCheckOfDateRepository todoCheckOfDateRepository) {
        this.userRepository = userRepository;
        this.todoCheckOfDateRepository = todoCheckOfDateRepository;
    }

    public UserTodoInfoWrapper checkUserAndWriteDate(String userId, String writeDate) {
        User targetUser = userRepository.findById(userId).orElse(null);
        if (targetUser == null)
            return new UserTodoInfoWrapper(false, "사용자를 못찾았어유", null, null);
        TodoCheckOfDate targetTodoCheckOfDate =
                todoCheckOfDateRepository.findByUserAndWriteDate(targetUser, writeDate).orElse(null);
        UserTodoInfoWrapper tcodCheckResult = tcodCheck(targetTodoCheckOfDate); // 추상 형식
        if (!tcodCheckResult.isSuccess()) return tcodCheckResult;
        return new UserTodoInfoWrapper(true, "확인 성공이어유", targetUser, targetTodoCheckOfDate);
    }

    protected abstract UserTodoInfoWrapper tcodCheck(TodoCheckOfDate targetTodoCheckOfDate);
}
