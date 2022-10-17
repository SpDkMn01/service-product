package com.nttdata.bootcamp.project.Product.service;

import com.nttdata.bootcamp.project.Product.dto.ProductTypeDto;
import com.nttdata.bootcamp.project.Product.repository.IProductTypeRepository;
import com.nttdata.bootcamp.project.Product.utils.IProductTypeMapper;
import com.nttdata.bootcamp.project.Product.utils.ProductTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <h1>Product Type Service</h1>
 * Esta clase tiene la finalidad de concentrar la logica necesaria para el CRUD de los objetos ProductType
 * @author Grupo05
 * @version 1.0
 * @since 2022-10-14
 */
@Service
@RequiredArgsConstructor
public class ProductTypeService implements IProductTypeService<ProductTypeDto, ProductTypeDto>{
    @Autowired
    private final IProductTypeRepository productTypeRepository;
    @Override
    public Flux<ProductTypeDto> getAll()
    {
        IProductTypeMapper mapper = new ProductTypeMapper();
        return productTypeRepository.findAll()
                .map(mapper::toDto);
    }
    @Override
    public Mono<ProductTypeDto> getById(String id)
    {
        IProductTypeMapper mapper = new ProductTypeMapper();
        return productTypeRepository.findById(id)
                .map(mapper::toDto);
    }
    @Override
    public Mono<ProductTypeDto> save(Mono<ProductTypeDto> object)
    {
        IProductTypeMapper mapper = new ProductTypeMapper();
        return object.map(mapper::toEntity)
                .flatMap(productTypeRepository::insert)
                .map(mapper::toDto);
    }
    @Override
    public Mono<ProductTypeDto> update(Mono<ProductTypeDto> object, String id)
    {
        IProductTypeMapper mapper = new ProductTypeMapper();
        return productTypeRepository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(productTypeRepository::save)
                .map(mapper::toDto);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return productTypeRepository.deleteById(id);
    }
}