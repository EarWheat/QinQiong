package com.zero.qinqiong.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private Long userId;

    private String userName;

    private String password;

    private String passport;

    private String loginToken;

    private Date birthTime;

    private Date createTime;

    private Date updateTime;
}