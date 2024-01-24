package com.example.petdiary_server.service.withDesignPattern.community.getScreensStrategy;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.community.res.ScreenRes;
import com.example.petdiary_server.repository.ScreenRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class ComGetScreensStrategy {
    protected ScreenRepository screenRepository;

    public abstract ResStatus<List<ScreenRes>> getScreens(String message);
}
