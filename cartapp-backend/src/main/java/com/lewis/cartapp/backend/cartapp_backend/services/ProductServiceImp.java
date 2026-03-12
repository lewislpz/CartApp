package com.lewis.cartapp.backend.cartapp_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.cartapp.backend.cartapp_backend.models.entities.Product;
import com.lewis.cartapp.backend.cartapp_backend.repositories.ProductRepository;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>)repository.findAll();
    }

}
