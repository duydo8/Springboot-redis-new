package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisPubSubQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/pubsub")
public class RedisPubSubQueueController {

    @Autowired
    private RedisPubSubQueueService redisPubSubQueueService;

    // Phát hành thông điệp vào channel
    @PostMapping("/publish")
    public String publishMessage(@RequestParam String message) {
        redisPubSubQueueService.publishMessage(message);
        return "Message published!";
    }

    // Bắt đầu subscribing vào channel (ví dụ này cần chạy như một thread)
    @GetMapping("/subscribe")
    public String subscribe() {
        new Thread(() -> redisPubSubQueueService.subscribe()).start();
        return "Subscribed to channel!";
    }
}
