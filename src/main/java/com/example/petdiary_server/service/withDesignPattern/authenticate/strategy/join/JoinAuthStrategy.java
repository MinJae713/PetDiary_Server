package com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.join;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.authenticate.req.JoinReq;
import com.example.petdiary_server.dto.authenticate.res.JoinRes;
import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.repository.UserRepository;

public class JoinAuthStrategy extends JoinStrategy{
    public JoinAuthStrategy(UserRepository userRepository, JoinReq joinReq) {
        super(userRepository, joinReq);
    }

    @Override
    public ResStatus<JoinRes> authenticate() {
        User sameUser = userRepository.findById(joinReq.getId()).orElse(null);
        if (sameUser != null)
            return new ResStatus<JoinRes>(false, "동일 회원정보가 존재합니다.\n아이디를 다시 입력해 주세요", null);
        User user = joinReq.createUser();
        User result = userRepository.save(user);
        if (result == null)
            return new ResStatus(false, "저장이 안되었네유?!", null);
        return new ResStatus(true, "저장 성공이어유!", result.createJoinRes());
    }
}
