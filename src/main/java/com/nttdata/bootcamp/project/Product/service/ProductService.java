package com.nttdata.bootcamp.project.Product.service;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.repository.IProductRespository;
import com.nttdata.bootcamp.project.Product.utils.IProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * <h1>Product Service</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService<ProductDtoRequest, ProductDtoResponse>{
    @Autowired
    private final IProductRespository repository;
    @Autowired
    private final IProductMapper mapper;
    @Override
    public Flux<ProductDtoResponse> getAll() {
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> getById(String id)
    {
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> save(Mono<ProductDtoRequest> object)
    {
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> update(Mono<ProductDtoRequest> object, String id)
    {
        return repository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return repository.deleteById(id);
    }
}