package com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.authStrategy;

import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.community.Note;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.AbstWrapper;
import com.example.petdiary_server.service.withDesignPattern.community.wrapper.NoteWrapper;

public class NoteAuth extends ComAuthStrategy {
    public NoteAuth(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository,
            String userId, String param) {
        super(userRepository, noteRepository, screenRepository, userId, param);
    }
    @Override
    public AbstWrapper operate() {
        User targetUser = userRepository.findById(userId).orElse(null);
        if (targetUser == null) return new NoteWrapper(false, "사용자를 못찾았어유", null, null);
        Note targetNote = noteRepository.findById(param).orElse(null);
        if (targetNote == null) return new NoteWrapper(false, "게시글을 못찾았어유", null, null);
        return new NoteWrapper(true, "인증 성공이어유",targetUser, targetNote);
    }
}
