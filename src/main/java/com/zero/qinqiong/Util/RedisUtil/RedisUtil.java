package com.zero.qinqiong.Util.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-24 19:06
 * @desc:
 */
@Component
public class RedisUtil<T> implements Serializable{
    private static final long serialVersionUID = 7359605494937920277L;

    @Autowired
    private RedisTemplate redisTemplate;

    public Object getValue(String key) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    public void setValue(String key, T value, Long time, TimeUnit timeUnit){
        ValueOperations<String, T> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        redisTemplate.expire(key,time,timeUnit);
    }
}
