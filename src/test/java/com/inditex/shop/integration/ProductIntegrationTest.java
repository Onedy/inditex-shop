package com.inditex.shop.integration;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @CsvSource({"1,2020-06-14T10:00:00+01:00,35.50",
        "1,2020-06-14T16:00:00+01:00,25.45",
        "1,2020-06-14T21:00:00+01:00,35.50",
        "1,2020-06-15T10:00:00+01:00,30.50",
        "1,2020-06-16T21:00:00+01:00,38.95"})
    void shouldRetrieveProductCreatedByFlyway_whenGetToProductEndpoint(long brandId, OffsetDateTime dateTime,
        BigDecimal expectedPrice) throws Exception {
        mockMvc.perform(get("/product/{id}", 35455L)
                .queryParam("brandId", String.valueOf(brandId))
                .queryParam("when", dateTime.toString()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price.amount").value(comparesEqualTo(expectedPrice.doubleValue())));
    }

    @Test
    void shouldReturnNotFound_whenProductDoesntExist() throws Exception {
        mockMvc.perform(get("/product/{id}", 133L)
                .queryParam("brandId", "1")
                .queryParam("when", "2020-06-14T10:00:00+01:00"))
            .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnBadRequest_whenBodyIsNotValid() throws Exception {
        mockMvc.perform(get("/product/{id}", 1L))
            .andExpect(status().isBadRequest()); //missing required brandId
    }
}