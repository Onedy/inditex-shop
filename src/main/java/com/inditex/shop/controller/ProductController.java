package com.inditex.shop.controller;

import com.inditex.shop.api.ProductApi;
import com.inditex.shop.dto.Product;
import com.inditex.shop.service.ProductService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<Product> findProduct(Long id, Long brandId, OffsetDateTime when) {
        return ResponseEntity.ok(productService.getProduct(id, brandId, when));
    }
}
