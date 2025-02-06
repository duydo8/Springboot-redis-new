package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/redis/set")
public class RedisSetController {

    @Autowired
    private RedisSetService redisSetService;

    // Thêm phần tử vào Redis Set
    @PostMapping("/add")
    public String addToSet(@RequestParam String key, @RequestParam String value) {
        redisSetService.addToSet(key, value);
        return "Added to Set!";
    }

    // Kiểm tra phần tử có trong Redis Set không
    @GetMapping("/isMember")
    public boolean isMember(@RequestParam String key, @RequestParam String value) {
        return redisSetService.isMember(key, value);
    }

    // Lấy tất cả các phần tử trong Redis Set
    @GetMapping("/get")
    public Set<Object> getSet(@RequestParam String key) {
        return redisSetService.getSet(key);
    }

    // Xóa phần tử khỏi Redis Set
    @DeleteMapping("/remove")
    public String removeFromSet(@RequestParam String key, @RequestParam String value) {
        redisSetService.removeFromSet(key, value);
        return "Removed from Set!";
    }

    // Sửa phần tử trong Redis Set
    @PutMapping("/update")
    public String updateSet(@RequestParam String key, @RequestParam String oldValue, @RequestParam String newValue) {
        redisSetService.updateSet(key, oldValue, newValue);
        return "Updated Set!";
    }
}