package com.zero.qinqiong.Service.ServiceImpl;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-14 16:15
 * @desc:
 */
public interface SignInService {
    JSONObject login(String UserName, String PassWord);
    boolean checkLoginStatus(HttpServletRequest httpServletRequest);
}
