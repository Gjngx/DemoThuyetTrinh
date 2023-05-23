package com.example.Demo_JPA_Filter_Search.controller;

import com.example.Demo_JPA_Filter_Search.entity.Product;
import com.example.Demo_JPA_Filter_Search.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @GetMapping("/sort")
    public List<Product> getAllSort (@RequestParam String field) {
        return repository.findAll(Sort.by(Sort.Direction.DESC, field));
    }
    @GetMapping("/name")
    public ResponseEntity<List<Product>> getLaptopsByName(@RequestParam String name) {
        return new ResponseEntity<List<Product>>(repository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> getLaptopsByCategory(@RequestParam String category) {
        return new ResponseEntity<List<Product>>(repository.findByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> getByPrice(@RequestParam Long price) {
        return new ResponseEntity<List<Product>>(repository.findByPrice(price), HttpStatus.OK);
    }

    @GetMapping("/page")
    public List<Product> getAllPage (@RequestParam Integer page, @RequestParam Integer size) {
        Pageable pages = PageRequest.of(page, size);
        return repository.findAll(pages).toList();
    }

}
