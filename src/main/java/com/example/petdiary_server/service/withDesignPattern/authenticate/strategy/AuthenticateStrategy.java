package com.example.petdiary_server.service.withDesignPattern.authenticate.strategy;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AuthenticateStrategy<T> {
    protected UserRepository userRepository;

    public abstract ResStatus<T> authenticate();
}
