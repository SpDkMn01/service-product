package com.nttdata.bootcamp.project.Product.service;

import com.nttdata.bootcamp.project.Product.dto.ProductTypeDto;
import com.nttdata.bootcamp.project.Product.repository.IProductTypeRepository;
import com.nttdata.bootcamp.project.Product.utils.IProductTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <h1>Product Type Service</h1>
 * Esta clase tiene la finalidad de concentrar la logica necesaria para el CRUD de los objetos ProductType
 * @author Grupo06
 * @version 1.0
 * @since 2022-10-14
 */
@Service
@RequiredArgsConstructor
public class ProductTypeService implements IProductTypeService<ProductTypeDto, ProductTypeDto>{
    @Autowired
    private final IProductTypeRepository repository;
    @Autowired
    private final IProductTypeMapper mapper;
    @Override
    public Flux<ProductTypeDto> getAll()
    {
        return repository.findAll()
                .map(mapper::toDto);
    }
    @Override
    public Mono<ProductTypeDto> getById(String id)
    {
        return repository.findById(id)
                .map(mapper::toDto);
    }
    @Override
    public Mono<ProductTypeDto> save(Mono<ProductTypeDto> object)
    {
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDto);
    }
    @Override
    public Mono<ProductTypeDto> update(Mono<ProductTypeDto> object, String id)
    {
        return repository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(mapper::toDto);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return repository.deleteById(id);
    }
}