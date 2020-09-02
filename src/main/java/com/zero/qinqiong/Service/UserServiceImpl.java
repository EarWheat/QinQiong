package com.zero.qinqiong.Service;

import com.zero.qinqiong.Dao.UserMapper;
import com.zero.qinqiong.Entity.User;
import com.zero.qinqiong.Service.ServiceImpl.UserService;
import com.zero.qinqiong.Util.RedisUtil.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-24 14:21
 * @desc:
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private RedisUtil<String> redisUtil;

    @Autowired
    private UserMapper userMapper;

    // 注册
    @Override
    public void register(String userName, String passWord) {
        redisUtil.setValue(userName,passWord,3L, TimeUnit.DAYS);
    }

    // 校验密码
    @Override
    public boolean checkPassword(User user) {
        User u = userMapper.selectByUserNameAndPwd(user);
        if(u != null){
            return true;
        } else {
            return false;
        }
    }
}
