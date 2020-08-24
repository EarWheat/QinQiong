package com.zero.qinqiong.Service;

import com.pangu.Redis.RedisUtil;
import com.zero.qinqiong.Service.ServiceImpl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-24 14:21
 * @desc:
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    // 注册
    @Override
    public void register(String userName, String passWord) {
        String redisResult = RedisUtil.set(userName,passWord);
        logger.info("user register redis:" + redisResult );
    }

    // 校验密码
    @Override
    public boolean checkPassword(String userName, String passWord) {
        return RedisUtil.get(userName).equals(passWord);
    }
}
