package com.example.petdiary_server.dto.checklist.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddTodoCheckReq {
    private NewTask newTask;
    private String userId;
}
