package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.cu;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.req.NoteReq;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.ComCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;

import java.util.List;

public abstract class ComCUStrategy extends ComCRUDStrategy {
    protected NoteReq noteReq;
    public ComCUStrategy(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository,
            NoteReq noteReq) {
        super(userRepository, noteRepository, screenRepository);
        this.noteReq = noteReq;
    }
    protected ResStatus<List<NoteRes>> checkAuth(AbstWrapper authResult) {
        if (!authResult.isSuccess())
            return new ResStatus<List<NoteRes>>(false, authResult.getMessage(), null);
        if (noteReq.getTitle().length() == 0)
            return new ResStatus<List<NoteRes>>(false, "제목이 아무것도 안 적혔습니다.", null);
        if (noteReq.getDesc().length() == 0)
            return new ResStatus<List<NoteRes>>(false, "내용이 아무것도 안 적혔습니다.", null);
        return new ResStatus<List<NoteRes>>(true, "인증 완료입니다.", null);
    }
}
