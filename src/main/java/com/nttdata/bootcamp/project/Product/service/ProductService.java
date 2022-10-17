package com.nttdata.bootcamp.project.Product.service;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.repository.IProductRespository;
import com.nttdata.bootcamp.project.Product.utils.IProductMapper;
import com.nttdata.bootcamp.project.Product.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService<ProductDtoRequest, ProductDtoResponse>{
    @Autowired
    private final IProductRespository repository;
    @Value("${message.uri}")
    String uri;
    @Override
    public Flux<ProductDtoResponse> getAll() {
        IProductMapper mapper = new ProductMapper(uri);
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> getById(String id)
    {
        IProductMapper mapper = new ProductMapper(uri);
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> save(Mono<ProductDtoRequest> object)
    {
        IProductMapper mapper = new ProductMapper(uri);
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> update(Mono<ProductDtoRequest> object, String id)
    {
        IProductMapper mapper = new ProductMapper(uri);
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