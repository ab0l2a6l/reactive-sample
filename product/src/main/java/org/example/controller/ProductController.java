package org.example.controller;

import org.example.model.entity.Product;
import org.example.model.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/find/{id}")
    public Mono<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/findAll")
    public Flux<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/save")
    public Mono<Product> save( @RequestBody Product product) {
        return productService.save(product);
    }

}
