package com.example.petdiary_server.controller;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.authenticate.req.JoinReq;
import com.example.petdiary_server.dto.authenticate.req.LoginReq;
import com.example.petdiary_server.dto.authenticate.res.JoinRes;
import com.example.petdiary_server.dto.authenticate.res.LoginRes;
import com.example.petdiary_server.service.AuthenticateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@Slf4j
public class AuthenticateController {
    @Autowired
    private AuthenticateService authenticateService;
    @PostMapping("/login")
    public ResponseEntity<ResStatus<LoginRes>> login(@RequestBody LoginReq loginReq) {
        ResStatus<LoginRes> result = authenticateService.login(loginReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/join")
    public ResponseEntity<ResStatus<JoinRes>> join(@RequestBody JoinReq joinReq) {
        ResStatus<JoinRes> result = authenticateService.join(joinReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
