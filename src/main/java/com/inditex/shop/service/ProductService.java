package com.inditex.shop.service;

import com.inditex.shop.dto.Product;
import com.inditex.shop.dto.ProductFactory;
import com.inditex.shop.entity.Price;
import com.inditex.shop.exception.NotFoundException;
import com.inditex.shop.repository.PriceRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PriceRepository priceRepository;
    private final ProductFactory productFactory;

    public Product getProduct(long id, long brandId, OffsetDateTime priceDateTime) {
        Price price = priceRepository.findFirstByProductIdAndBrandIdAndDateBetween(id, brandId, priceDateTime)
            .orElseThrow(() -> new NotFoundException("Product or price not found for this criteria"));

        return productFactory.build(price);
    }
}
