package com.example.petdiary_server.service.withDesignPattern.authenticate.factory;

import com.example.petdiary_server.dto.authenticate.req.JoinReq;
import com.example.petdiary_server.dto.authenticate.req.LoginReq;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.AuthenticateStrategy;
import com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.join.JoinAuthStrategy;
import com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.login.LoginAuthStrategy;

public class AuthenticateAuthFactory extends AuthenticateFactory{
    public AuthenticateAuthFactory(UserRepository userRepository) {
        super(userRepository);
    }
    @Override
    public AuthenticateStrategy createLoginStrategy(LoginReq loginReq) {
        return new LoginAuthStrategy(userRepository, loginReq);
    }
    @Override
    public AuthenticateStrategy createJoinStrategy(JoinReq joinReq) {
        return new JoinAuthStrategy(userRepository, joinReq);
    }
}
