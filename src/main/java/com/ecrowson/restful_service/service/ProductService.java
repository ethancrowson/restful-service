package com.ecrowson.restful_service.service;

import com.ecrowson.restful_service.model.Product;
import com.ecrowson.restful_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProduct(Integer id){
        return productRepo.findById(id).orElseThrow(() -> new IllegalStateException("product with id " + id + " does not exist."));
    }

    public void addProduct(Product product) {
        Optional<Product> productOptional =
                productRepo.findProductByDescription(product.getDescription());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Description Taken.");
        }
        productRepo.save(product);
        System.out.println(product);
    }

    public void deleteProduct(Integer productId) {
        boolean exists = productRepo.existsById(productId);
        if (!exists) {
            throw new IllegalStateException("product with id " + productId + " does not exist.");
        }
        productRepo.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Integer id, String description, BigDecimal price) {
        Product product = productRepo.findById(id).orElseThrow(() -> new IllegalStateException("product with id " + id + " does not exist."));

        if (description != null &&
                !description.isEmpty() &&
                !Objects.equals(product.getDescription(), description)) {
            product.setDescription(description);
        }
        if (price != null && price.compareTo(BigDecimal.ZERO) > 0) {
            product.setPrice(price);
        }
    }
}
