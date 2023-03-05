package com.inditex.shop.infrastructure.configuration;

import com.inditex.shop.domain.factory.ProductFactory;
import com.inditex.shop.domain.repository.PriceRepository;
import com.inditex.shop.domain.service.DomainProductService;
import com.inditex.shop.domain.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductService productService(PriceRepository priceRepository, ProductFactory productFactory) {
        return new DomainProductService(priceRepository, productFactory);
    }
}
