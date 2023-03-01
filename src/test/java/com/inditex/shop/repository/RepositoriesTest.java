package com.inditex.shop.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.inditex.shop.entity.Price;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.util.Streamable;


@DataJpaTest
@AutoConfigureTestDatabase
public class RepositoriesTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    void shouldAutowireAndRetrievePrices() {
        List<Price> prices = Streamable.of(priceRepository.findAll()).toList();

        assertThat(prices).hasSize(4);
    }
}
