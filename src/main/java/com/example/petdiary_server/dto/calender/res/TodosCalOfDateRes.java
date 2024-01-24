package com.example.petdiary_server.dto.calender.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodosCalOfDateRes {
    private String dateId;
    private int feelIdx;
    private String userId;
}
