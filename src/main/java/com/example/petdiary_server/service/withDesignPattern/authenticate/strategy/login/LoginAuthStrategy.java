package com.example.petdiary_server.service.withDesignPattern.authenticate.strategy.login;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.authenticate.req.LoginReq;
import com.example.petdiary_server.dto.authenticate.res.LoginRes;
import com.example.petdiary_server.entity.User;
import com.example.petdiary_server.repository.UserRepository;

public class LoginAuthStrategy extends LoginStrategy{
    public LoginAuthStrategy(UserRepository userRepository, LoginReq loginReq) {
        super(userRepository, loginReq);
    }

    @Override
    public ResStatus<LoginRes> authenticate() {
        String id = loginReq.getId();
        String pw = loginReq.getPw();
        if (id.length() == 0)
            return new ResStatus<LoginRes>(false, "아이디가 입력되지 않았습니다.", null);
        else if (pw.length() == 0)
            return new ResStatus<LoginRes>(false, "비밀번호가 입력되지 않았습니다.", null);
        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            return new ResStatus<LoginRes>(false, "입력 아이디에 해당하는 고객이 없습니다.", null);
        else if (!user.getPw().equals(pw))
            return new ResStatus<LoginRes>(false, "비밀번호가 맞지 않습니다.", null);
        return new ResStatus<LoginRes>(true, "로그인 성공!", user.createLoginRes());
    }
}
