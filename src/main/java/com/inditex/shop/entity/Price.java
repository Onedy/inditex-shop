package com.inditex.shop.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Price {

    @Id
    private long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    @Min(0)
    private BigDecimal price;
    @Size(min = 3, max = 3)
    private String currency;
}
