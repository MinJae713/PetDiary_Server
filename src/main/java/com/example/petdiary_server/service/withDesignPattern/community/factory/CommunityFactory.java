package com.example.petdiary_server.service.withDesignPattern.community.factory;

import com.example.petdiary_server.dto.community.req.NoteReq;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.ComStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.ComCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.getScreensStrategy.ComGetScreensStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CommunityFactory {
    // 추상 팩토리 패턴 적용(다른 인스턴스 반환 시 새로 구현해서 사용)
    protected UserRepository userRepository;
    protected NoteRepository noteRepository;
    protected ScreenRepository screenRepository;

    public abstract ComStrategy createGetStrategy(String userId, String screenTitle);
    public abstract ComStrategy createDeleteStrategy(String id, String userId);
    public abstract ComStrategy createEditStrategy(NoteReq noteReq);
    public abstract ComStrategy createSubmitStrategy(NoteReq noteReq);
    public abstract ComGetScreensStrategy createGetScreenStrategy(String type);
}
