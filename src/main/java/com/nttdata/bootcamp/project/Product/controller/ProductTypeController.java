package com.nttdata.bootcamp.project.Product.controller;

import com.nttdata.bootcamp.project.Product.dto.ProductTypeDto;
import com.nttdata.bootcamp.project.Product.service.IProductTypeService;
import com.nttdata.bootcamp.project.Product.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-productType}")
@RefreshScope
public class ProductTypeController {
    @Autowired
    private IProductTypeService service;
    @GetMapping
    public Flux<ProductTypeDto> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Mono<ProductTypeDto> getById(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<ProductTypeDto> save(@RequestBody Mono<ProductTypeDto> productTypeDtoMono)
    {
        return service.save(productTypeDtoMono);
    }
    @PutMapping("/update/{id}")
    public Mono<ProductTypeDto> update(@RequestBody Mono<ProductTypeDto> productTypeDtoMono, @PathVariable String id)
    {
        return service.update(productTypeDtoMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id)
    {
        return service.delete(id);
    }
}
