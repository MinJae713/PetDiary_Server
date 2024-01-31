package com.example.petdiary_server.service.withDesignPattern.community.getScreensStrategy;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.res.ScreenRes;
import com.example.petdiary_server.entity.community.Screen;
import com.example.petdiary_server.repository.ScreenRepository;

import java.util.ArrayList;
import java.util.List;

public class ComGetScreenTitlesStrategy extends ComGetScreensStrategy{
    protected String type;

    public ComGetScreenTitlesStrategy(ScreenRepository screenRepository, String type) {
        super(screenRepository);
        this.type = type;
    }

    @Override
    public ResStatus<List<ScreenRes>> getScreens(String message) {
        List<Screen> screens = screenRepository.findAllByType(type).orElse(null);
        if (screens == null) return new ResStatus<List<ScreenRes>>(false, "게시물을 못불러왔습니다.", null);
        List<ScreenRes> screenReses = new ArrayList<ScreenRes>();
        for (Screen screen : screens) screenReses.add(screen.getScreenRes());
        return new ResStatus<List<ScreenRes>>(true, message, screenReses);
    }
}
