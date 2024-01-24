package com.example.petdiary_server.service;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.req.NoteReq;
import com.example.petdiary_server.dto.community.res.NoteRes;
import com.example.petdiary_server.dto.community.res.ScreenRes;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.ComStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.ComCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.factory.CommunityFactory;
import com.example.petdiary_server.service.withDesignPattern.community.factory.ComNotesScreensFactory;
import com.example.petdiary_server.service.withDesignPattern.community.getScreensStrategy.ComGetScreensStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommunityService {
    private ComStrategy crudStrategy;
    private ComGetScreensStrategy screensStrategy;
    private CommunityFactory factory;

    @Autowired
    public CommunityService(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository) {
        this.factory = new ComNotesScreensFactory(userRepository, noteRepository, screenRepository);
        // 추상 팩토리 - 다른 Strategy들 반환하고 싶으면 클래스 새로 구현해서 여기만 바꾸면 됨(아래 메소드들 바꿀 필요 없음)
    }

    public ResStatus<List<NoteRes>> getNotes(String userId, String screenTitle) {
        crudStrategy = factory.createGetStrategy(userId, screenTitle);
        return (ResStatus<List<NoteRes>>)crudStrategy.operate();
    }
    public ResStatus<List<NoteRes>> deleteNote(String id, String userId) {
        crudStrategy = factory.createDeleteStrategy(id, userId);
        return (ResStatus<List<NoteRes>>)crudStrategy.operate();
    }
    public ResStatus<List<NoteRes>> editNote(NoteReq noteReq) {
        crudStrategy = factory.createEditStrategy(noteReq);
        return (ResStatus<List<NoteRes>>)crudStrategy.operate();
    }
    public ResStatus<List<NoteRes>> submitNote(NoteReq noteReq) {
        crudStrategy = factory.createSubmitStrategy(noteReq);
        return (ResStatus<List<NoteRes>>)crudStrategy.operate();
    }
    public ResStatus<List<ScreenRes>> getScreenTitles(String type) {
        screensStrategy = factory.createGetScreenStrategy(type);
        return screensStrategy.getScreens("게시물 불러오기 성공이어유");
    }
}
