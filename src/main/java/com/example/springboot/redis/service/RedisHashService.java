package com.example.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisHashService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Thêm trường và giá trị vào Redis Hash
    public void addToHash(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    // Lấy giá trị từ Redis Hash theo trường (hashKey)
    public Object getFromHash(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    // Lấy tất cả các trường và giá trị trong Redis Hash
    public Map<Object, Object> getAllFromHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    // Xóa trường khỏi Redis Hash
    public void removeFromHash(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    // Kiểm tra trường trong Redis Hash
    public boolean hasKeyInHash(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }
}