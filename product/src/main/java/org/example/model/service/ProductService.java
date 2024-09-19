package org.example.model.service;

import org.example.dto.Coupon;
import org.example.model.entity.Product;
import org.example.model.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final WebClient webClient;

    public ProductService(ProductRepository productRepository, WebClient webClient) {
        this.productRepository = productRepository;
        this.webClient = webClient;
    }

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> save(Product product) {
        Mono<Coupon> couponMono = webClient.get()
                .uri("/api/v1/discount/find/{code}", product.getCode())
                .retrieve()
                .bodyToMono(Coupon.class);
            couponMono.subscribe( v -> {
                product.setPrice(
                        product.getPrice().multiply( new BigDecimal("0.9"))
                );
            });

        return productRepository.save(product);
    }
}
