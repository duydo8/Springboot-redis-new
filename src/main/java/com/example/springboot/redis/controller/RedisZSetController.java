package com.example.springboot.redis.controller;

import com.example.springboot.redis.service.RedisZSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/redis/zset")
public class RedisZSetController {

    @Autowired
    private RedisZSetService redisZSetService;

    // Thêm phần tử vào Sorted Set
    @PostMapping("/add")
    public String addToZSet(@RequestParam String key, @RequestParam String value, @RequestParam double score) {
        redisZSetService.addToZSet(key, value, score);
        return "Element added to Sorted Set!";
    }

    // Lấy tất cả phần tử trong Sorted Set
    @GetMapping("/getAll")
    public Set<Object> getAllFromZSet(@RequestParam String key) {
        return redisZSetService.getAllFromZSet(key);
    }

    // Lấy phần tử trong Sorted Set theo khoảng điểm số
    @GetMapping("/getByScore")
    public Set<Object> getByScore(@RequestParam String key, @RequestParam double minScore, @RequestParam double maxScore) {
        return redisZSetService.getByScore(key, minScore, maxScore);
    }

    // Lấy phần tử trong Sorted Set theo thứ tự giảm dần
    @GetMapping("/getAllDescending")
    public Set<Object> getAllFromZSetDescending(@RequestParam String key) {
        return redisZSetService.getAllFromZSetDescending(key);
    }

    // Lấy kích thước của Sorted Set
    @GetMapping("/size")
    public long getZSetSize(@RequestParam String key) {
        return redisZSetService.getZSetSize(key);
    }

    // Lấy điểm số của một phần tử
    @GetMapping("/getScore")
    public Double getScore(@RequestParam String key, @RequestParam String value) {
        return redisZSetService.getScore(key, value);
    }

    // Xóa phần tử khỏi Sorted Set
    @DeleteMapping("/remove")
    public String removeFromZSet(@RequestParam String key, @RequestParam String value) {
        redisZSetService.removeFromZSet(key, value);
        return "Element removed from Sorted Set!";
    }

    // Xóa các phần tử trong Sorted Set theo điểm số
    @DeleteMapping("/removeByScore")
    public String removeByScore(@RequestParam String key, @RequestParam double minScore, @RequestParam double maxScore) {
        redisZSetService.removeByScore(key, minScore, maxScore);
        return "Elements removed from Sorted Set by score!";
    }
}