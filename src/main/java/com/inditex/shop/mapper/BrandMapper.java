package com.inditex.shop.mapper;

import com.inditex.shop.dto.ProductBrand;
import com.inditex.shop.entity.Brand;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper {

    ProductBrand toDto(Brand brand);
}
