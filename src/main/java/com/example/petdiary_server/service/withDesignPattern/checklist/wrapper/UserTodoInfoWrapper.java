package com.example.petdiary_server.service.withDesignPattern.checklist.wrapper;

import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.entity.checklist.TodoCheckOfDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class UserTodoInfoWrapper {
    private boolean success;
    private String message;
    private User user;
    private TodoCheckOfDate todoCheckOfDate;
}
