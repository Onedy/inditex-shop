package com.inditex.shop.domain.service;

import com.inditex.shop.application.dto.Product;
import java.time.OffsetDateTime;

public interface ProductService {

    Product getProduct(long id, long brandId, OffsetDateTime priceDateTime);
}
