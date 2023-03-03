package com.inditex.shop.repository;

import com.inditex.shop.entity.Price;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {

    @Query(value = "SELECT * FROM price p "
        + "WHERE p.product_id = ?1 AND "
        + "p.brand_id = ?2 AND "
        + "?3 BETWEEN p.start_date AND p.end_date "
        + "ORDER BY p.priority DESC "
        + "LIMIT 1",
        nativeQuery = true)
    Optional<Price> findFirstByProductIdAndBrandIdAndDateBetween(long productId, long brandId, OffsetDateTime dateTime);
}
