package com.inditex.shop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.shop.dto.ProductFactory;
import com.inditex.shop.entity.Price;
import com.inditex.shop.exception.NotFoundException;
import com.inditex.shop.repository.PriceRepository;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private PriceRepository priceRepository;
    @Mock
    private ProductFactory productFactory;
    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnExpectedProduct_whenGetProductIsCalled() {
        Price priceInDb = mock(Price.class);
        when(priceRepository.findFirstByProductIdAndBrandIdAndDateBetween(anyLong(), anyLong(),
            any(OffsetDateTime.class)))
            .thenReturn(Optional.of(priceInDb));

        productService.getProduct(1L, 1L, OffsetDateTime.now());

        verify(productFactory).build(priceInDb);
    }

    @Test
    void shouldThrowNotFoundException_whenPriceRepositoryReturnsEmptyOptional() {
        assertThatThrownBy(() -> productService.getProduct(anyLong(), anyLong(), any(OffsetDateTime.class)))
            .isInstanceOf(NotFoundException.class);
    }
}
