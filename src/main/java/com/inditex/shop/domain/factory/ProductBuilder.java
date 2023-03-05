package com.inditex.shop.domain.factory;

import com.inditex.shop.application.dto.Money;
import com.inditex.shop.application.dto.Product;
import com.inditex.shop.domain.entity.Price;
import com.inditex.shop.domain.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductBuilder {

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
