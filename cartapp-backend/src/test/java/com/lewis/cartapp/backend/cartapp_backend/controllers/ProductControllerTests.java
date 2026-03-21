package com.lewis.cartapp.backend.cartapp_backend.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lewis.cartapp.backend.cartapp_backend.models.entities.Product;
import com.lewis.cartapp.backend.cartapp_backend.services.ProductService;

class ProductControllerTests {

    private MockMvc mockMvc;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        ProductController controller = new ProductController();
        productService = mock(ProductService.class);

        ReflectionTestUtils.setField(controller, "service", productService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getProductsReturnsProductList() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setName("Keyboard");
        product.setDescription("Mechanical keyboard");
        product.setPrice(99L);

        when(productService.findAll()).thenReturn(List.of(product));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Keyboard"))
                .andExpect(jsonPath("$[0].description").value("Mechanical keyboard"))
                .andExpect(jsonPath("$[0].price").value(99));
    }
}
