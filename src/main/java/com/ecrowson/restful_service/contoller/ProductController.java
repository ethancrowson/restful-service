package com.ecrowson.restful_service.contoller;

import com.ecrowson.restful_service.contoller.model.ProductID;
import com.ecrowson.restful_service.model.Product;
import com.ecrowson.restful_service.repository.ProductRepo;
import com.ecrowson.restful_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    ProductRepo repo;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/test")
    public String testThymeleaf(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "test";
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<ProductID> addProduct(@RequestBody final Product product) {
        productService.addProduct(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable("id") final Integer id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{id}")
    public void updateProduct(
            @PathVariable("id") final Integer id,
            @RequestParam(required = false) String description,
            @RequestParam(required = false)BigDecimal price
            ) {
        productService.updateProduct(id, description, price);
    }

    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable final Integer id) {
        System.out.println(id);
        return productService.getProduct(id);
    }

    @PostMapping("/add-product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product) {
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        repo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }
    @PatchMapping("/product")
    public void pathProduct(@RequestBody final Product product) {
        System.out.println(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id) {
        System.out.println(id);
    }

}
