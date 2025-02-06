package com.example.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisPubSubQueueService {

    private static final String CHANNEL = "taskChannel"; // Tên Channel

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // Phát hành thông điệp vào channel (PUBLISH)
    public void publishMessage(String message) {
        redisTemplate.convertAndSend(CHANNEL, message);
    }

    // Subscribing vào Channel (listener)
    public void subscribe() {
        redisTemplate.getConnectionFactory().getConnection().subscribe((message, pattern) -> {
            String task = new String(message.getBody());
            System.out.println("Received task: " + task);
        }, CHANNEL.getBytes());
    }
}
