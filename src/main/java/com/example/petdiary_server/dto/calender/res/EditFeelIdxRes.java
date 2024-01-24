package com.example.petdiary_server.dto.calender.res;

import com.example.petdiary_server.dto.ResStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EditFeelIdxRes {
    private String dateId;
    private int feelIdx;
    private String userId;
}
