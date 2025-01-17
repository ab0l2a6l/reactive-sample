package org.example.model.repository;

import org.example.model.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends ReactiveCrudRepository<Product, Long> {

}
