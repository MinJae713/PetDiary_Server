package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.rd;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.entity.community.Screen;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy.ScreenAuth;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.ScreenWrapper;

import java.util.List;

public class ComGetStrategy extends ComRDStrategy {
    public ComGetStrategy(UserRepository userRepository,
                          NoteRepository noteRepository,
                          ScreenRepository screenRepository,
                          String userId, String param) {
        super(userRepository, noteRepository, screenRepository, userId, param);
        authStrategy = new ScreenAuth(userRepository, noteRepository, screenRepository, userId, param);
    }

    @Override
    public ResStatus<List<NoteRes>> operate() {
        AbstWrapper authResult = (AbstWrapper)authStrategy.operate();
        if (!authResult.isSuccess())
            return new ResStatus<List<NoteRes>>(false, authResult.getMessage(), null);
        ScreenWrapper screenWrapper = (ScreenWrapper) authResult;
        Screen targetScreen = screenWrapper.getScreen();
        return getNotesRes(targetScreen);
    }
}
