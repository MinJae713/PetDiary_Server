package com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.join;

import com.example.petdiary_server.dto.authenticate.req.JoinReq;
import com.example.petdiary_server.dto.authenticate.res.JoinRes;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.AuthenticateStrategy;

public abstract class JoinStrategy extends AuthenticateStrategy<JoinRes> {
    protected JoinReq joinReq;
    public JoinStrategy(UserRepository userRepository, JoinReq joinReq) {
        super(userRepository);
        this.joinReq = joinReq;
    }
}
