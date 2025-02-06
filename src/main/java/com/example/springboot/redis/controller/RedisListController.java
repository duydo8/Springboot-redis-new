package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/redis/list")
public class RedisListController {

    @Autowired
    private RedisListService redisListService;

    // Thêm phần tử vào Redis List
    @PostMapping("/add")
    public String addToList(@RequestParam String key, @RequestParam Object value) {
        redisListService.addToList(key, value);
        return "Value added to Redis List!";
    }

    // Lấy tất cả phần tử trong Redis List
    @GetMapping("/getAll")
    public List<Object> getAllFromList(@RequestParam String key) {
        return redisListService.getAllFromList(key);
    }

    // Lấy phần tử đầu tiên trong Redis List
    @GetMapping("/getFirst")
    public Object getFirstFromList(@RequestParam String key) {
        return redisListService.getFirstFromList(key);
    }

    // Lấy phần tử cuối cùng trong Redis List
    @GetMapping("/getLast")
    public Object getLastFromList(@RequestParam String key) {
        return redisListService.getLastFromList(key);
    }

    // Lấy phần tử cuối cùng trong Redis List
    @DeleteMapping("/delete")
    public Object removeFromList(@RequestParam String key, @RequestParam Object value) {
        redisListService.removeFromList(key, value);
        return "Value removed from Redis List!";
    }
}
