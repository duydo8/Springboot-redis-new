package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisListService;
import com.example.springboot.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisListController {
    @Autowired
    private RedisStringService redisStringService;

    @Autowired
    private RedisListService redisListService;

    // Lưu dữ liệu vào Redis String
    @PostMapping("/string/set")
    public String setString(@RequestParam String key, @RequestParam String value) {
        redisStringService.saveToString(key, value);
        return "Value added to Redis String!";
    }

    // Lấy dữ liệu từ Redis String
    @GetMapping("/string/get")
    public Object getString(@RequestParam String key) {
        return redisStringService.getFromString(key);
    }

    // Thêm phần tử vào Redis List
    @PostMapping("/list/add")
    public String addToList(@RequestParam String key, @RequestParam Object value) {
        redisListService.addToList(key, value);
        return "Value added to Redis List!";
    }

    // Lấy tất cả phần tử trong Redis List
    @GetMapping("/list/getAll")
    public List<Object> getAllFromList(@RequestParam String key) {
        return redisListService.getAllFromList(key);
    }

    // Lấy phần tử đầu tiên trong Redis List
    @GetMapping("/list/getFirst")
    public Object getFirstFromList(@RequestParam String key) {
        return redisListService.getFirstFromList(key);
    }

    // Lấy phần tử cuối cùng trong Redis List
    @GetMapping("/list/getLast")
    public Object getLastFromList(@RequestParam String key) {
        return redisListService.getLastFromList(key);
    }
}
