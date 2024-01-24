package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.rd;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.entity.community.Note;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy.NoteAuth;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.NoteWrapper;

import java.util.List;

public class ComDeleteStrategy extends ComRDStrategy {
    public ComDeleteStrategy(UserRepository userRepository,
                             NoteRepository noteRepository,
                             ScreenRepository screenRepository,
                             String userId, String param) {
        super(userRepository, noteRepository, screenRepository, userId, param);
        authStrategy = new NoteAuth(userRepository, noteRepository, screenRepository, userId, param);
    }

    @Override
    public ResStatus<List<NoteRes>> operate() {
        AbstWrapper authResult = (AbstWrapper)authStrategy.operate();
        if (!authResult.isSuccess())
            return new ResStatus<List<NoteRes>>(false, authResult.getMessage(), null);
        NoteWrapper noteWrapper = (NoteWrapper) authResult;
        Note targetNote = noteWrapper.getNote();
        noteRepository.delete(targetNote);
        return getNotesRes(targetNote.getScreen());
    }
}
