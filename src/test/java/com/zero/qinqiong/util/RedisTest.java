package com.zero.qinqiong.util;

import com.zero.qinqiong.Util.RedisUtil.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/*
 * @author:liuzhaolu
 * @createTime: 2020-09-07 19:34
 * @desc:
 */
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtil<String> redisUtil;

//    @Test
//    public void test(){
//        redisUtil.setValue("Spring boot","test",120L, TimeUnit.SECONDS);
//        String redisResult = (String)redisUtil.getValue("Spring boot");
//        System.out.println(redisResult);
//    }
    @Test
    void print(){
        System.out.println("hello test");
    }
}
