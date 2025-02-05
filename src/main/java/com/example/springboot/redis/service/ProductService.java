package com.example.springboot.redis.service;

import com.example.springboot.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate redisTemplate;

    public Product saveProduct(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public Product findProductById(Integer id) {
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public List<Product> getAllProduct() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public void deleteProduct(Integer id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }
}
