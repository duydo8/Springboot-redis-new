package com.example.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisZSetService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Thêm phần tử vào Sorted Set với điểm số
    public void addToZSet(String key, Object value, double score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    // Lấy tất cả các phần tử trong Sorted Set
    public Set<Object> getAllFromZSet(String key) {
        return redisTemplate.opsForZSet().range(key, 0, -1); // lấy tất cả phần tử từ đầu đến cuối
    }

    // Lấy các phần tử trong Sorted Set theo khoảng điểm số
    public Set<Object> getByScore(String key, double minScore, double maxScore) {
        return redisTemplate.opsForZSet().rangeByScore(key, minScore, maxScore);
    }

    // Lấy phần tử trong Sorted Set theo thứ tự giảm dần
    public Set<Object> getAllFromZSetDescending(String key) {
        return redisTemplate.opsForZSet().reverseRange(key, 0, -1); // lấy tất cả phần tử từ cuối đến đầu
    }

    // Lấy số lượng phần tử trong Sorted Set
    public long getZSetSize(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    // Lấy điểm số của một phần tử trong Sorted Set
    public Double getScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    // Xóa phần tử khỏi Sorted Set
    public void removeFromZSet(String key, Object value) {
        redisTemplate.opsForZSet().remove(key, value);
    }

    // Xóa các phần tử trong Sorted Set theo khoảng điểm số
    public void removeByScore(String key, double minScore, double maxScore) {
        redisTemplate.opsForZSet().removeRangeByScore(key, minScore, maxScore);
    }
}