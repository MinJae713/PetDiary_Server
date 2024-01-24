package com.example.petdiary_server.service;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.authenticate.req.JoinReq;
import com.example.petdiary_server.dto.authenticate.req.LoginReq;
import com.example.petdiary_server.dto.authenticate.res.JoinRes;
import com.example.petdiary_server.dto.authenticate.res.LoginRes;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.authenticate.factory.AuthenticateAuthFactory;
import com.example.petdiary_server.service.withDesignPattern.authenticate.factory.AuthenticateFactory;
import com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.AuthenticateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {
    private AuthenticateFactory authenticateFactory;
    private AuthenticateStrategy authenticateStrategy;

    @Autowired
    public AuthenticateService(UserRepository userRepository) {
        authenticateFactory = new AuthenticateAuthFactory(userRepository);
    }

    public ResStatus<LoginRes> login(LoginReq loginReq) {
        authenticateStrategy = authenticateFactory.createLoginStrategy(loginReq);
        return authenticateStrategy.authenticate();
    }

    public ResStatus<JoinRes> join(JoinReq joinReq) {
        authenticateStrategy = authenticateFactory.createJoinStrategy(joinReq);
        return authenticateStrategy.authenticate();
    }
}
