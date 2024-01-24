package com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.login;

import com.example.petdiary_server.dto.authenticate.req.LoginReq;
import com.example.petdiary_server.dto.authenticate.res.LoginRes;
import com.example.petdiary_server.repository.UserRepository;
import com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.AuthenticateStrategy;

public abstract class LoginStrategy extends AuthenticateStrategy<LoginRes> {
    protected LoginReq loginReq;
    public LoginStrategy(UserRepository userRepository, LoginReq loginReq) {
        super(userRepository);
        this.loginReq = loginReq;
    }
}
