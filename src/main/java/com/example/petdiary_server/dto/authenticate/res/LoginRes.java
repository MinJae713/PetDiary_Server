package com.example.petdiary_server.dto.authenticate.res;

import com.example.petdiary_server.dto.ResStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {
    private String id;
    private String pw;
    private String name;
    private String nickName;
    private int age;
}
