package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.cu;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.req.NoteReq;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.community.Note;
import com.example.petdiary_server.entity.community.Screen;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy.ScreenAuth;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.ScreenWrapper;

import java.util.List;

public class ComCreateStrategy extends ComCUStrategy {
    public ComCreateStrategy(UserRepository userRepository, NoteRepository noteRepository, ScreenRepository screenRepository, NoteReq noteReq) {
        super(userRepository, noteRepository, screenRepository, noteReq);
        authStrategy = new ScreenAuth(
                userRepository,
                noteRepository,
                screenRepository,
                noteReq.getUserId(),
                noteReq.getScreenTitle());
    }

    @Override
    public ResStatus<List<NoteRes>> operate() {
        AbstWrapper authResult = (AbstWrapper)authStrategy.operate();
        ResStatus<List<NoteRes>> authCheck = checkAuth(authResult);
        if (!authCheck.isSuccess()) return authCheck;
        ScreenWrapper screenWrapper = (ScreenWrapper) authResult;
        Screen targetScreen = screenWrapper.getScreen();
        User targetUser = screenWrapper.getUser();
        Note targetNote = new Note(
                noteReq.getId(),
                noteReq.getTitle(),
                noteReq.getDesc(),
                noteReq.isUpdated(),
                noteReq.getTime(),
                targetScreen, targetUser
        );
        Note saveResult = noteRepository.save(targetNote);
        if (saveResult == null)
            return new ResStatus<List<NoteRes>>(false, "저장이 안되었습니다.", null);
        return getNotesRes(targetScreen);
    }
}
