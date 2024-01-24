package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy;

import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.ComStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;

public abstract class ComAuthStrategy extends ComStrategy<AbstWrapper> {
    // 전략 패턴 응용 - SRP만족(입력 값에 대한 인증 ㄱㄴ)
    protected String userId;
    protected String param;

    public ComAuthStrategy(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository,
            String userId, String param) {
        super(userRepository, noteRepository, screenRepository);
        this.userId = userId;
        this.param = param;
    }
}
