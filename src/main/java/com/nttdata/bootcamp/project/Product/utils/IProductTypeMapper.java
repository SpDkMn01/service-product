package com.nttdata.bootcamp.project.Product.utils;

import com.nttdata.bootcamp.project.Product.dto.ProductTypeDto;
import com.nttdata.bootcamp.project.Product.entity.ProductType;
/**
 * <h1>IProductType Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
public interface IProductTypeMapper {
    ProductTypeDto toDto(ProductType productType);
    ProductType toEntity(ProductTypeDto productTypeDto);
}
