package com.example.Demo_JPA_Filter_Search.repository;

import com.example.Demo_JPA_Filter_Search.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByCategory(String name);

    @Query("SELECT u FROM Product u WHERE u.price > :price")
    List<Product> findByPrice(@Param("price") long price);
}
