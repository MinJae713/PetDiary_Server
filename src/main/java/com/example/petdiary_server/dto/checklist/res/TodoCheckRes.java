package com.example.petdiary_server.dto.checklist.res;

import com.example.petdiary_server.dto.ResStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoCheckRes {
    private String id;
    private String textValue;
    private boolean checked;
    private String writeDate;
}
