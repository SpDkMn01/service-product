package com.nttdata.bootcamp.project.Product.service;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.repository.IProductRespository;
import com.nttdata.bootcamp.project.Product.repository.IProductTypeRepository;
import com.nttdata.bootcamp.project.Product.utils.IProductMapper;
import com.nttdata.bootcamp.project.Product.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService<ProductDtoRequest, ProductDtoResponse>{
    @Autowired
    private final IProductRespository productRespository;
    @Autowired
    private final IProductTypeRepository productTypeRepository;
    @Override
    public Flux<ProductDtoResponse> getAll() {
        IProductMapper mapper = new ProductMapper();
        return productRespository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> getById(String id)
    {
        IProductMapper mapper = new ProductMapper();
        return productRespository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> save(Mono<ProductDtoRequest> object)
    {
        IProductMapper mapper = new ProductMapper();
        return object.map(mapper::toEntity)
                .flatMap(productRespository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<ProductDtoResponse> update(Mono<ProductDtoRequest> object, String id)
    {
        IProductMapper mapper = new ProductMapper();
        return productRespository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(productRespository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return productRespository.deleteById(id);
    }
}