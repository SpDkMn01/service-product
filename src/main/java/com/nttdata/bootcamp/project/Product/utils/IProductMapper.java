package com.nttdata.bootcamp.project.Product.utils;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.entity.Product;

public interface IProductMapper {
    ProductDtoRequest toDtoRequest(Product product);
    Product toEntity(ProductDtoRequest productDtoRequest);
    ProductDtoResponse toDtoResponse(Product product);
}
