package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/queue")
public class RedisQueueController {
    @Autowired
    private RedisQueueService redisQueueService;

    // Thêm task vào queue
    @PostMapping("/enqueue")
    public String enqueue(@RequestParam String task) {
        redisQueueService.enqueue(task);
        return "Task added to queue!";
    }

    // Lấy task từ queue
    @GetMapping("/dequeue")
    public String dequeue() {
        String task = redisQueueService.dequeue();
        return task != null ? "Dequeued task: " + task : "Queue is empty!";
    }

    // Kiểm tra kích thước của queue
    @GetMapping("/size")
    public Long getQueueSize() {
        return redisQueueService.getQueueSize();
    }
}