package com.example.petdiary_server.dto.calender.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AllTodosInfoRes {
    private String dateId;
    private int feelIdx;
    private String userId;
    private List<TodoCalRes> todos;
}
