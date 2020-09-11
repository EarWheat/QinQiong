package com.zero.qinqiong.Service;

import com.zero.qinqiong.Entity.User;
import com.zero.qinqiong.Service.ServiceImpl.SignInService;
import com.zero.qinqiong.Util.RedisUtil.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-14 16:17
 * @desc:
 */
@Service("SignInService")
public class SignInServiceImpl implements SignInService {

    @Resource
    private RedisUtil<String> redisUtil;

    @Override
    public boolean login(String userName, String passWord) {
        String userPassWord = (String) redisUtil.getValue(userName);
        return userPassWord.equals(passWord);
    }

    @Override
    public boolean checkLoginStatus(HttpServletRequest httpServletRequest, User user) {
        HttpSession session = httpServletRequest.getSession();
        String loginToken = (String) redisUtil.getValue(user.getUserName());
        if(StringUtils.isNotBlank(loginToken)){
            return session.toString().equals(loginToken);
        }
        return false;
    }
}
