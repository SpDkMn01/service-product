package com.nttdata.bootcamp.project.Product.utils;

import com.nttdata.bootcamp.project.Product.dto.ProductTypeDto;
import com.nttdata.bootcamp.project.Product.entity.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
/**
 * <h1>ProductType Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@RequiredArgsConstructor
@Component
public class ProductTypeMapper implements IProductTypeMapper {
    @Override
    public ProductTypeDto toDto(ProductType productType){
        ProductTypeDto productTypeDto = new ProductTypeDto();
        BeanUtils.copyProperties(productType, productTypeDto);
        return productTypeDto;
    }
    @Override
    public ProductType toEntity(ProductTypeDto productTypeDto){
        ProductType productType = new ProductType();
        BeanUtils.copyProperties(productTypeDto, productType);
        return productType;
    }
}
