package com.inditex.shop.dto;

import com.inditex.shop.entity.Price;
import com.inditex.shop.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFactory {

    private final BrandMapper brandMapper;

    public Product build(Price price) {
        return Product.builder()
            .id(price.getProduct().getId())
            .name(price.getProduct().getName())
            .brand(brandMapper.toDto(price.getBrand()))
            .priceList(price.getId())
            .price(Money.builder()
                .amount(price.getPrice())
                .currency(price.getCurrency())
                .build())
            .startDate(price.getStartDate())
            .endDate(price.getEndDate())
            .build();
    }
}
