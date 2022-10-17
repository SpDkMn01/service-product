package com.nttdata.bootcamp.project.Product.utils;

import com.nttdata.bootcamp.project.Product.dto.ProductTypeDto;
import com.nttdata.bootcamp.project.Product.entity.ProductType;

public interface IProductTypeMapper {
    ProductTypeDto toDto(ProductType productType);
    ProductType toEntity(ProductTypeDto productTypeDto);
}
