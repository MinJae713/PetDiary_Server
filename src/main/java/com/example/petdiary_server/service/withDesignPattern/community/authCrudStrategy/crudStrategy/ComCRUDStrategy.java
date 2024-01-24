package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.entity.community.Note;
import com.example.petdiary_server.entity.community.Screen;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.ComStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy.ComAuthStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class ComCRUDStrategy extends ComStrategy<ResStatus<List<NoteRes>>> {
    // 전략 패턴 응용 - SRP 만족(community 기능 담당, 새 파라미터가 필요하면 얘 상속해서 사용)
    protected ComStrategy authStrategy;

    public ComCRUDStrategy(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository) {
        super(userRepository, noteRepository, screenRepository);
    }

    protected ResStatus<List<NoteRes>> getNotesRes(Screen targetScreen) {
        // 게시글 리스트 반환 작업
        List<Note> targetNotes = noteRepository.findAllByScreen(targetScreen).orElse(null);
        if (targetNotes == null) return new ResStatus<List<NoteRes>>(false, "등록된 게시글이 아무것도 없어유", null);
        List<NoteRes> noteReses = new ArrayList<NoteRes>();
        for (Note note : targetNotes) noteReses.add(note.getNoteRes());
        ResStatus<List<NoteRes>> result = new ResStatus<List<NoteRes>>(true, "조회 성공이어유!", noteReses);
        return result;
    }
}
