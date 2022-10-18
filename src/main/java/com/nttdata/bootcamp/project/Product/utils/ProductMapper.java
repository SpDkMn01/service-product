package com.nttdata.bootcamp.project.Product.utils;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * <h1>Product Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@RequiredArgsConstructor
@Component
public class ProductMapper implements IProductMapper {
    @Value("${message.uri}")
    private String uri;
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
        productDtoResponse.setProductTypeUrl(uri + product.getProductTypeId());
        return productDtoResponse;
    }
}