package com.inditex.shop.domain.service;

import com.inditex.shop.application.dto.Product;
import com.inditex.shop.application.exception.NotFoundException;
import com.inditex.shop.domain.entity.Price;
import com.inditex.shop.domain.factory.ProductBuilder;
import com.inditex.shop.domain.repository.PriceRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DomainProductService implements ProductService {

    private final PriceRepository priceRepository;
    private final ProductBuilder productBuilder;

    @Override
    public Product getProduct(long id, long brandId, OffsetDateTime priceDateTime) {
        Price price = priceRepository.findFirstByProductIdAndBrandIdAndDateBetween(id, brandId, priceDateTime)
            .orElseThrow(() -> new NotFoundException("Product or price not found for this criteria"));

        return productBuilder.build(price);
    }
}
