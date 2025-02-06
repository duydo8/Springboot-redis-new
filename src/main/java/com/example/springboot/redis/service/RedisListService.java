package com.example.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisListService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Thêm phần tử vào Redis List (phía cuối)
    public void addToList(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    // Lấy tất cả phần tử trong Redis List
    public List<Object> getAllFromList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    // Lấy phần tử đầu tiên trong Redis List
    public Object getFirstFromList(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    // Lấy phần tử cuối cùng trong Redis List
    public Object getLastFromList(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    // Xóa phần tử khỏi Redis List
    public void removeFromList(String key, Object value) {
        redisTemplate.opsForList().remove(key, 0, value);
    }

    // Lấy kích thước của Redis List
    public long getListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }
}
