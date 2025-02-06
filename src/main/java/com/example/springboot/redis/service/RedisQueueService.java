package com.example.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueService {
    private static final String QUEUE_KEY = "taskQueue"; // Tên queue

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Thêm task vào queue (LPUSH)
    public void enqueue(String task) {
        redisTemplate.opsForList().leftPush(QUEUE_KEY, task);
    }

    // Lấy task từ queue (RPOP)
    public String dequeue() {
        return (String) redisTemplate.opsForList().rightPop(QUEUE_KEY);
    }

    // Kiểm tra kích thước của queue
    public Long getQueueSize() {
        return redisTemplate.opsForList().size(QUEUE_KEY);
    }
}