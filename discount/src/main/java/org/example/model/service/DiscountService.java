package org.example.model.service;

import org.example.model.entity.Coupon;
import org.example.model.repository.DiscountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DiscountService {
    private final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Mono<Coupon> findById(Long id) {
        return discountRepository.findById(id);
    }

    public Flux<Coupon> findAll() {
        return discountRepository.findAll();
    }

    public Mono<Coupon> save(Coupon coupon) {
        return discountRepository.save(coupon);
    }

    public Mono<Coupon> findByCode(String code) {
        return discountRepository.findByCode(code);
    }
}
