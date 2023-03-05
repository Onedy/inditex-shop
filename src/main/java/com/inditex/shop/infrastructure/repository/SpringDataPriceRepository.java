package com.inditex.shop.infrastructure.repository;

import com.inditex.shop.domain.entity.Price;
import com.inditex.shop.domain.repository.PriceRepository;
import java.time.OffsetDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringDataPriceRepository implements PriceRepository {

    private final SpringDataPriceCrudRepository priceCrudRepository;

    @Override
    public Optional<Price> findFirstByProductIdAndBrandIdAndDateBetween(long productId, long brandId,
        OffsetDateTime dateTime) {
        return priceCrudRepository.findFirstByProductIdAndBrandIdAndDateBetween(productId, brandId, dateTime);
    }
}
