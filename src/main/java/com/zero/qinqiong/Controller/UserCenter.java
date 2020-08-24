package com.zero.qinqiong.Controller;

import com.alibaba.fastjson.JSONObject;
import com.pangu.http.request.HttpClient;
import com.pangu.http.response.RestResult;
import com.pangu.http.response.ResultEnum;
import com.zero.qinqiong.Entity.User;
import com.zero.qinqiong.Service.ServiceImpl.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-24 14:21
 * @desc: 用户中心
 */
@RestController
@SpringBootApplication
@RequestMapping("/user")
public class UserCenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCenter.class);

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public RestResult<JSONObject> welcome(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("welcome","Hello world!");
        return RestResult.successResult(jsonObject);
    }

    @RequestMapping("/register")
    public RestResult<JSONObject> register(@RequestBody User user){
        if(StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassWord())){
            return RestResult.failResult(ResultEnum.PARAM_ERROR);
        }
        try {
            userService.register(user.getUserName(),user.getPassWord());
        } catch (Exception e){
            e.printStackTrace();
            LOGGER.error("user:"+user.getUserName() + "register error! " + e.toString());
            return RestResult.failResult(ResultEnum.EXCEPTION);
        }
        return RestResult.successResult();
    }
}
