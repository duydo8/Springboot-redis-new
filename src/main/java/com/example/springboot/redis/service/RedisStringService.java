package com.example.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisStringService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Lưu giá trị vào Redis String
    public void saveToString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Lấy giá trị từ Redis String
    public Object getFromString(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // Xóa key trong Redis String
    public void deleteFromString(String key) {
        redisTemplate.delete(key);
    }

    // Kiểm tra sự tồn tại của key trong Redis
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}