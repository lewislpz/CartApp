package com.lewis.cartapp.backend.cartapp_backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.lewis.cartapp.backend.cartapp_backend.models.entities.Product;
import com.lewis.cartapp.backend.cartapp_backend.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    public List<Product> list() {
        return service.findAll();
    }

}
