package org.example.model.repository;

import org.example.model.entity.Coupon;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DiscountRepository extends ReactiveCrudRepository<Coupon, Long> {
    Mono<Coupon> findByCode(String code);
}
