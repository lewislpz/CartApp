package com.lewis.cartapp.backend.cartapp_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lewis.cartapp.backend.cartapp_backend.models.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {



}
