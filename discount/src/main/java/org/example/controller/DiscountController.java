package org.example.controller;

import org.example.model.entity.Coupon;
import org.example.model.service.DiscountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Coupon> findById(@PathVariable("id") Long id) {
        return discountService.findById(id);
    }

    @GetMapping(value = "/find/{code}")
    public Mono<Coupon> findByCode(@PathVariable("code") String code) {
        return discountService.findByCode(code);
    }

    @GetMapping(value = "/findall", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Coupon> findAll() {
        return discountService.findAll();
    }

    @PostMapping
    public Mono<Coupon> save(@RequestBody Coupon coupon) {
        return discountService.save(coupon);
    }
}
