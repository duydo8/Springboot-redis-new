package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/redis/hash")
public class RedisHashController {

    @Autowired
    private RedisHashService redisHashService;

    // Thêm trường và giá trị vào Redis Hash
    @PostMapping("/add")
    public String addToHash(@RequestParam String key, @RequestParam String hashKey, @RequestParam Object value) {
        redisHashService.addToHash(key, hashKey, value);
        return "Added to Hash!";
    }

    // Lấy giá trị từ Redis Hash
    @GetMapping("/get")
    public Object getFromHash(@RequestParam String key, @RequestParam String hashKey) {
        return redisHashService.getFromHash(key, hashKey);
    }

    // Lấy tất cả các trường và giá trị trong Redis Hash
    @GetMapping("/getAll")
    public Map<Object, Object> getAllFromHash(@RequestParam String key) {
        return redisHashService.getAllFromHash(key);
    }

    // Xóa trường khỏi Redis Hash
    @DeleteMapping("/remove")
    public String removeFromHash(@RequestParam String key, @RequestParam String hashKey) {
        redisHashService.removeFromHash(key, hashKey);
        return "Removed from Hash!";
    }

    // Kiểm tra trường trong Redis Hash
    @GetMapping("/hasKey")
    public boolean hasKeyInHash(@RequestParam String key, @RequestParam String hashKey) {
        return redisHashService.hasKeyInHash(key, hashKey);
    }
}