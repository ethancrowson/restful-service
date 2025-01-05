package com.ecrowson.restful_service;

import com.ecrowson.restful_service.model.Product;
import com.ecrowson.restful_service.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepo repo) {
        return args -> {
            Product AirForce = new Product(
                    "AirForce",
                    new BigDecimal("99.99")
            );
            Product Jordan = new Product(
                    "Jordan",
                    new BigDecimal("169.99")
            );
            Product Blazer = new Product(
                    "Blazer",
                    new BigDecimal("74.99")
            );
            Product Crater = new Product(
                    "Crater",
                    new BigDecimal("84.99")
            );
            Product Hippie = new Product(
                    "Hippie",
                    new BigDecimal("72.99")
            );

            repo.saveAll(List.of(AirForce, Jordan, Blazer, Crater, Hippie));
        };
    }
}
