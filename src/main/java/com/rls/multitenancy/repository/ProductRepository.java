package com.rls.multitenancy.repository;

import com.rls.multitenancy.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}