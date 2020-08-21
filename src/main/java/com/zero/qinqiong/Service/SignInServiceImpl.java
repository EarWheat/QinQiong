package com.zero.qinqiong.Service;

import com.alibaba.fastjson.JSONObject;
import com.zero.qinqiong.Service.ServiceImpl.SignInService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-14 16:17
 * @desc:
 */
@Service("SignInService")
public class SignInServiceImpl implements SignInService {

    @Override
    public JSONObject login(String UserName, String PassWord) {
        return null;
    }

    @Override
    public boolean checkLoginStatus(HttpServletRequest httpServletRequest) {
        return false;
    }
}
