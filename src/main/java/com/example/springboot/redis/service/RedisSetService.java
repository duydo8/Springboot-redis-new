package com.example.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisSetService {
    @Autowired
    private RedisTemplate redisTemplate;

    //---------------------------Thao tác với Set---------------------------
    // Thêm phần tử vào Set
    public void addToSet(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    // Kiểm tra phần tử có trong Set không
    public boolean isMember(String key, String value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    // Lấy tất cả các phần tử trong Set
    public Set<Object> getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    // Xóa phần tử khỏi Redis Set
    public void removeFromSet(String key, String value) {
        redisTemplate.opsForSet().remove(key, value);
    }

    // Sửa phần tử trong Redis Set (xóa phần tử cũ và thêm phần tử mới)
    public void updateSet(String key, String oldValue, String newValue) {
        // Xóa phần tử cũ
        removeFromSet(key, oldValue);
        // Thêm phần tử mới
        addToSet(key, newValue);
    }
}