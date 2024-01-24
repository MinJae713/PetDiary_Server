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
    // 추상 팩토리 - 다른 Strategy들 반환하고 싶으면 클래스 새로 구현해서 여기만 바꾸면 됨(아래 메소드들 바꿀 필요 없음)

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
