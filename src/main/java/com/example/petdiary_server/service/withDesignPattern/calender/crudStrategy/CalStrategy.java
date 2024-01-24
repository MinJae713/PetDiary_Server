package com.example.petdiary_server.service.withDesignPattern.calender.crudStrategy;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.repository.TodoCalOfDateRepository;
import com.example.petdiary_server.repository.TodoCalRepository;
import com.example.petdiary_server.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class CalStrategy<T> {
    protected UserRepository userRepository;
    protected TodoCalOfDateRepository todoCalOfDateRepository;
    protected TodoCalRepository todoCalRepository;

    public abstract ResStatus<T> crudCal(String successMessage);
}
