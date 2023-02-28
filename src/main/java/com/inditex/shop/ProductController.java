package com.inditex.shop;

import com.inditex.shop.api.ProductApi;
import com.inditex.shop.dto.Product;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {

    @Override
    public ResponseEntity<List<Product>> findProducts(Integer id, Integer brandId, String when) {
        return null;
    }
}
