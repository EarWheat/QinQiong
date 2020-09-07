package com.zero.qinqiong.Service.ServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.zero.qinqiong.Entity.User;

import javax.servlet.http.HttpServletRequest;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-14 16:15
 * @desc:
 */
public interface SignInService {
    boolean login(String userName, String passWord);
    boolean checkLoginStatus(HttpServletRequest httpServletRequest, User user);
}
