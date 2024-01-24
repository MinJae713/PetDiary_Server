package com.example.petdiary_server.service.withDesignPattern.community.factory;

import com.example.petdiary_server.dto.community.req.NoteReq;
import com.example.petdiary_server.repository.NoteRepository;
import com.example.petdiary_server.repository.ScreenRepository;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.ComStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.ComCRUDStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.cu.ComCreateStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.cu.ComEditStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.rd.ComDeleteStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.authCrudStrategy.crudStrategy.rd.ComGetStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.getScreensStrategy.ComGetScreenTitlesStrategy;
import com.example.petdiary_server.service.withDesignPattern.community.getScreensStrategy.ComGetScreensStrategy;

public class ComNotesScreensFactory extends CommunityFactory {
    public ComNotesScreensFactory(
            UserRepository userRepository,
            NoteRepository noteRepository,
            ScreenRepository screenRepository) {
        super(userRepository, noteRepository, screenRepository);
    }
    @Override
    public ComStrategy createGetStrategy(String userId, String screenTitle) {
        return new ComGetStrategy(userRepository, noteRepository, screenRepository, userId, screenTitle);
    }
    @Override
    public ComStrategy createDeleteStrategy(String id, String userId) {
        return new ComDeleteStrategy(userRepository, noteRepository, screenRepository, userId, id);
    }
    @Override
    public ComStrategy createEditStrategy(NoteReq noteReq) {
        return new ComEditStrategy(userRepository, noteRepository, screenRepository, noteReq);
    }
    @Override
    public ComStrategy createSubmitStrategy(NoteReq noteReq) {
        return new ComCreateStrategy(userRepository, noteRepository, screenRepository, noteReq);
    }
    @Override
    public ComGetScreensStrategy createGetScreenStrategy(String type) {
        return new ComGetScreenTitlesStrategy(screenRepository, type);
    }
}
