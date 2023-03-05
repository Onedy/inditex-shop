package com.inditex.shop.application.controller;

import com.inditex.shop.application.controller.api.ProductApi;
import com.inditex.shop.application.dto.Product;
import com.inditex.shop.domain.service.ProductService;
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
