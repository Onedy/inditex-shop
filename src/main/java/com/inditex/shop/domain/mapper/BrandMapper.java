package com.inditex.shop.domain.mapper;

import com.inditex.shop.application.dto.ProductBrand;
import com.inditex.shop.domain.entity.Brand;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper {

    ProductBrand toDto(Brand brand);
}
