package com.example.springboot.redis.controller;

import com.example.springboot.redis.entity.Product;
import com.example.springboot.redis.response.BaseRespone;
import com.example.springboot.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        if (product.getId() == null) {
            return ResponseEntity.badRequest().body(
                    new BaseRespone(400, "ID must be not empty", null)
            );
        }

        return ResponseEntity.ok().body(
                new BaseRespone(200, "Save successfully ProductId: " + product.getId(), productService.saveProduct(product))
        );
    }

    @GetMapping("/findAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok().body(
                new BaseRespone(200, "Get all product successfully", productService.getAllProduct())
        );
    }

    @PostMapping("/findById")
    public ResponseEntity findById(@RequestParam Integer id) {
        return ResponseEntity.ok().body(
                new BaseRespone(200, "Get ProductId: " + id, productService.findProductById(id))
        );
    }

    @PutMapping("/update")
    public ResponseEntity updateById(@RequestParam Product product) {
        if (product.getId() == null) {
            return ResponseEntity.badRequest().body(
                    new BaseRespone(400, "ID must be not empty", null)
            );
        }
        Product currentProduct = productService.findProductById(product.getId());
        if (currentProduct == null) {
            return ResponseEntity.badRequest().body(
                    new BaseRespone(400, "Not found product", null)
            );
        }
        return ResponseEntity.ok().body(
                new BaseRespone(200, "Save successfully ProductId: " + product.getId(), productService.saveProduct(product))
        );
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity deleteById(@RequestParam Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body(
                new BaseRespone(200, "Delete ProductId: " + id, null)
        );
    }
}
