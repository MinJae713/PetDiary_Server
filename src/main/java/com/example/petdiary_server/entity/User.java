package com.example.petdiary_server.entity;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.authenticate.res.JoinRes;
import com.example.petdiary_server.dto.authenticate.res.LoginRes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "User")
public class User {
    @Id
    @Column(name = "userId", nullable = false, length = 50)
    private String userId;
    @Column(nullable = false, length = 50)
    private String pw;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = false, length = 100)
    private String nickname;
    @Column(nullable = false, length = 3)
    private int age;

    public JoinRes createJoinRes() {
        return new JoinRes(userId, pw, name, nickname, age);
    }
    public LoginRes createLoginRes() {
        return new LoginRes(userId, pw, name, nickname, age);
    }
}
