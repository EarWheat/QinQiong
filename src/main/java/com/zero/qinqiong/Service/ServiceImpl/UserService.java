package com.zero.qinqiong.Service.ServiceImpl;

import com.zero.qinqiong.Entity.User;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-24 14:19
 * @desc:
 */
public interface UserService {
    // 注册账号
    void register(String userName, String passWord);
    boolean checkPassword(User user);
}
