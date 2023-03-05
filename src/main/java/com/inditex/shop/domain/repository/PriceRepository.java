package com.inditex.shop.domain.repository;

import com.inditex.shop.domain.entity.Price;
import java.time.OffsetDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findFirstByProductIdAndBrandIdAndDateBetween(long productId, long brandId, OffsetDateTime dateTime);
}
