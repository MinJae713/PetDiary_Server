package com.example.petdiary_server.service.withDesignPattern.community.wrapper;

import com.example.petdiary_server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstWrapper {
    protected boolean success;
    protected String message;
    protected User user;
}
