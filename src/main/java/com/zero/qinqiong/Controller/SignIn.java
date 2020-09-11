package com.zero.qinqiong.Controller;

import com.alibaba.fastjson.JSONObject;
import com.pangu.http.response.RestResult;
import com.pangu.http.response.ResultEnum;
import com.zero.qinqiong.Entity.User;
import com.zero.qinqiong.Service.ServiceImpl.SignInService;
import com.zero.qinqiong.Service.ServiceImpl.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public RestResult<JSONObject> welcome(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("welcome","Hello world!");
        return RestResult.successResult(jsonObject);
    }

    @RequestMapping(value = "/login")
    public RestResult SignIn(HttpServletRequest request, HttpServletResponse response, @RequestBody User user){
        if(StringUtils.isBlank(user.getUserName())){
            return RestResult.failResult(ResultEnum.PARAM_EMPTY);
        }
        if(signInService.checkLoginStatus(request, user)){
            return RestResult.successResult(ResultEnum.USER_ONLINE);
        } else {
            if(StringUtils.isBlank(user.getPassword())){
                return RestResult.failResult(ResultEnum.PARAM_EMPTY);
            }
            HttpSession session = request.getSession();
            String loginToken = DigestUtils.md5DigestAsHex((new Date().toString() + session.getId()).getBytes());
            user.setLoginToken(loginToken);
            if(userService.checkPassword(user)){
                return RestResult.successResult(ResultEnum.LOGIN_SUCCESS);
            }
        }
        return RestResult.failResult(ResultEnum.LOGIN_ERROR);
    }
}
