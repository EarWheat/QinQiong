package com.zero.qinqiong.Controller;

import com.alibaba.fastjson.JSONObject;
import com.pangu.http.response.RestResult;
import com.pangu.http.response.ResultEnum;
import com.pangu.monitor.rest.RestCostTime;
import com.zero.qinqiong.Entity.User;
import com.zero.qinqiong.Service.ServiceImpl.SignInService;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-14 16:19
 * @desc:
 */
@RestController
@SpringBootApplication
public class SignIn {

    @Resource
    private SignInService signInService;

    @RequestMapping("/")
    public RestResult<JSONObject> welcome(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("welcome","Hello world!");
        return RestResult.successResult(jsonObject);
    }

    @RequestMapping(value = "/login")
    public RestResult SignIn(HttpServletRequest request, HttpServletResponse response, @RequestBody User user){
        if(StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassWord())){
            return RestResult.failResult(ResultEnum.PARAM_ERROR);
        }
        if(signInService.checkLoginStatus(request)){
            return RestResult.successResult();
        } else {
            String userName = user.getUserName();
            String passWord = user.getPassWord();
            HttpSession session = request.getSession();
            String loginToken = DigestUtils.md5DigestAsHex((new Date().toString() + session.getId()).getBytes());
            user.setLoginToken(loginToken);
        }
        return RestResult.successResult();
    }
}
