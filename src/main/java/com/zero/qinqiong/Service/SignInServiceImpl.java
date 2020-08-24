package com.zero.qinqiong.Service;

import com.alibaba.fastjson.JSONObject;
import com.pangu.redis.RedisUtil;
import com.zero.qinqiong.Service.ServiceImpl.SignInService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-14 16:17
 * @desc:
 */
@Service("SignInService")
public class SignInServiceImpl implements SignInService {

    @Override
    public boolean login(String userName, String passWord) {
        String userPassWord = RedisUtil.get(userName);
        return userPassWord.equals(passWord);
    }

    @Override
    public boolean checkLoginStatus(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        return false;
    }
}
