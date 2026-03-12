package com.lewis.cartapp.backend.cartapp_backend.services;

import java.util.List;

import com.lewis.cartapp.backend.cartapp_backend.models.entities.Product;

public interface ProductService {
    List<Product> findAll();
}
