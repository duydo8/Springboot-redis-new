package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/string")
public class RedisStringController {
    @Autowired
    private RedisStringService redisStringService;

    // Lưu dữ liệu vào Redis String
    @PostMapping("/set")
    public String setString(@RequestParam String key, @RequestParam String value) {
        redisStringService.saveToString(key, value);
        return "Value added to Redis String!";
    }

    // Lấy dữ liệu từ Redis String
    @GetMapping("/get")
    public Object getString(@RequestParam String key) {
        return redisStringService.getFromString(key);
    }

    // Lưu dữ liệu vào Redis String
    @DeleteMapping("/delete")
    public String delete(@RequestParam String key) {
        redisStringService.deleteFromString(key);
        return "DELETE key successfully!";
    }

    // Lấy dữ liệu từ Redis String
    @GetMapping("/hasKey")
    public Object hasKey(@RequestParam String key) {
        return redisStringService.hasKey(key);
    }
}
