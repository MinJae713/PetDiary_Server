package com.example.petdiary_server.dto.calender.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EditTodoCalReq {
    private String id;
    private String text;
}
