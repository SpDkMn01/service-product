package com.nttdata.bootcamp.project.Product.utils;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.entity.Product;
import org.springframework.beans.BeanUtils;

public class ProductMapper implements IProductMapper {
    @Override
    public ProductDtoRequest toDtoRequest(Product product) {
        ProductDtoRequest productDtoRequest = new ProductDtoRequest();
        BeanUtils.copyProperties(product, productDtoRequest);
        return productDtoRequest;
    }
    @Override
    public Product toEntity(ProductDtoRequest productDtoRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productDtoRequest, product);
        return product;
    }
    @Override
    public ProductDtoResponse toDtoResponse(Product product) {
        ProductDtoResponse productDtoResponse = new ProductDtoResponse();
        BeanUtils.copyProperties(product, productDtoResponse);
        productDtoResponse.setProductTypeUrl("/api/v1/productTypes/" + product.getProductTypeId());
        return productDtoResponse;
    }
}