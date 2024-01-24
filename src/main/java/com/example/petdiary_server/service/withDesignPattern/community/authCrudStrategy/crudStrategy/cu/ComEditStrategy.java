package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.cu;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.req.NoteReq;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.entity.community.Note;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy.NoteAuth;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.NoteWrapper;

import java.util.List;

public class ComEditStrategy extends ComCUStrategy {
    public ComEditStrategy(UserRepository userRepository, NoteRepository noteRepository, ScreenRepository screenRepository, NoteReq noteReq) {
        super(userRepository, noteRepository, screenRepository, noteReq);
        authStrategy = new NoteAuth(
                userRepository,
                noteRepository,
                screenRepository,
                noteReq.getUserId(),
                noteReq.getId());
    }

    @Override
    public ResStatus<List<NoteRes>> operate() {
        AbstWrapper authResult = (AbstWrapper)authStrategy.operate();
        ResStatus<List<NoteRes>> authCheck = checkAuth(authResult);
        if (!authCheck.isSuccess()) return authCheck;
        NoteWrapper noteWrapper = (NoteWrapper) authResult;
        Note targetNote = noteWrapper.getNote();
        targetNote.setTitle(noteReq.getTitle());
        targetNote.setDesc(noteReq.getDesc());
        targetNote.setUpdated(true);
        targetNote.setTime(noteReq.getTime());
        Note editResult = noteRepository.save(targetNote);
        if (editResult == null)
            return new ResStatus<List<NoteRes>>(false, "수정이 안되었어유", null);
        return getNotesRes(targetNote.getScreen());
    }
}
