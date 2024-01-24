package com.example.petdiary_server.dto.calender.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodosCalOfDateReq {
    private String dateId;
    private int feelIdx;
    private String userId;
}
