package com.example.petdiary_server.dto.authenticate.req;

import com.example.petdiary_server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JoinReq {
    private String id;
    private String pw;
    private String name;
    private String nickName;
    private int age;

    public User createUser() {
        return new User(id, pw, name, nickName, age);
    }
}
