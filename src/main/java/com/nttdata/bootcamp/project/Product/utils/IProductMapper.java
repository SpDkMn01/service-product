package com.nttdata.bootcamp.project.Product.utils;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.entity.Product;
/**
 * <h1>IProduct Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
public interface IProductMapper {
    ProductDtoRequest toDtoRequest(Product product);
    Product toEntity(ProductDtoRequest productDtoRequest);
    ProductDtoResponse toDtoResponse(Product product);
}
