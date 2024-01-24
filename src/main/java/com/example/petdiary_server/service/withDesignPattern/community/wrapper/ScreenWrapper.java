package com.example.petdiary_server.service.withDesignPattern.community.wrapper;

import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.community.Screen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ScreenWrapper extends AbstWrapper{
    protected Screen screen;

    public ScreenWrapper(boolean success, String message, User user, Screen screen) {
        super(success, message, user);
        this.screen = screen;
    }
}
