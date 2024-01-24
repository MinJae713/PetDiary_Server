package com.example.petdiary_server.service.withDesignPattern.authenticate.factory;

import com.example.petdiary_server.dto.authenticate.req.JoinReq;
import com.example.petdiary_server.dto.authenticate.req.LoginReq;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.AuthenticateStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AuthenticateFactory {
    protected UserRepository userRepository;
    public abstract AuthenticateStrategy createLoginStrategy(LoginReq loginReq);
    public abstract AuthenticateStrategy createJoinStrategy(JoinReq joinReq);
}
