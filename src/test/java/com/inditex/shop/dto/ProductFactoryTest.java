package com.inditex.shop.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.inditex.shop.entity.Brand;
import com.inditex.shop.entity.Price;
import com.inditex.shop.mapper.BrandMapper;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductFactoryTest {

    @Mock
    private BrandMapper brandMapper;
    @InjectMocks
    private ProductFactory productFactory;

    @Test
    void shouldBuildProductCorrectly() {
        long productId = 2L;
        long brandId = 1L;
        long priceList = 3L;
        BigDecimal priceAmount = new BigDecimal("45.25");
        String priceCurrency = "EUR";
        OffsetDateTime startDate = OffsetDateTime.parse("2023-11-03T10:15:30+01:00");
        OffsetDateTime endDate = OffsetDateTime.parse("2023-12-03T10:15:30+01:00");
        String brandName = "ZARA";
        String productName = "Zapatos";
        Price priceInDb = Price.builder()
            .id(priceList)
            .product(com.inditex.shop.entity.Product.builder()
                .id(productId)
                .name(productName)
                .build())
            .brand(Brand.builder()
                .id(brandId)
                .name(brandName)
                .build())
            .startDate(startDate)
            .endDate(endDate)
            .price(priceAmount)
            .currency(priceCurrency)
            .build();
        when(brandMapper.toDto(any(Brand.class))).thenReturn(ProductBrand.builder()
            .id(brandId)
            .name(brandName)
            .build());

        assertThat(productFactory.build(priceInDb))
            .isEqualTo(com.inditex.shop.dto.Product.builder()
                .id(productId)
                .name(productName)
                .brand(ProductBrand.builder()
                    .id(brandId)
                    .name(brandName)
                    .build())
                .priceList(priceList)
                .price(Money.builder()
                    .amount(priceAmount)
                    .currency(priceCurrency)
                    .build())
                .startDate(startDate)
                .endDate(endDate)
                .build()
            );
    }
}