package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy;

import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.community.Screen;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.ScreenWrapper;

public class ScreenAuth extends ComAuthStrategy {
    public ScreenAuth(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository,
            String userId, String param) {
        super(userRepository, noteRepository, screenRepository, userId, param);
    }
    @Override
    public AbstWrapper operate() {
        User targetUser = userRepository.findById(userId).orElse(null);
        if (targetUser == null) return new ScreenWrapper(false, "사용자를 못 찾았습니다.", null, null);
        Screen targetScreen = screenRepository.findByTitle(param).orElse(null);
        if (targetScreen == null) return new ScreenWrapper(false, "해당 게시판을 못 찾았습니다.", null, null);
        return new ScreenWrapper(true, "인증 성공입니다!", targetUser, targetScreen);
    }
}
