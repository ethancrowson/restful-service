package com.ecrowson.restful_service.repository;

import com.ecrowson.restful_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.description = ?1")
    Optional<Product> findProductByDescription(String description);
}
