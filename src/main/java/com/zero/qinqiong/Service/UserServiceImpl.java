package com.zero.qinqiong.Service;

import com.pangu.redis.RedisUtil;
import com.zero.qinqiong.Service.ServiceImpl.UserService;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-24 14:21
 * @desc:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void register(String userName, String passWord) {
        RedisUtil.set(userName,passWord);
    }
}
