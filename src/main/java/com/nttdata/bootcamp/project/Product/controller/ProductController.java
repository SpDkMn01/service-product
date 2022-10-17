package com.nttdata.bootcamp.project.Product.controller;

import com.nttdata.bootcamp.project.Product.dto.ProductDtoRequest;
import com.nttdata.bootcamp.project.Product.dto.ProductDtoResponse;
import com.nttdata.bootcamp.project.Product.service.ProductService;
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
@RequestMapping("${message.path-product}")
@RefreshScope
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;
    @GetMapping
    public Flux<ProductDtoResponse> getProducts()
    {
        return productService.getAll();
    }
    @GetMapping(path="/{id}")
    public Mono<ProductDtoResponse> getProduct(@PathVariable String id)
    {
        return productService.getById(id);
    }
    @PostMapping
    public Mono<ProductDtoResponse> saveProduct(@RequestBody Mono<ProductDtoRequest> productDtoRequest)
    {
        productDtoRequest.flatMap(p -> productTypeService.getById(p.getProductTypeId()));
        return productService.save(productDtoRequest);
    }
    @PutMapping("/update/{id}")
    public Mono<ProductDtoResponse> updateProduct(@RequestBody Mono<ProductDtoRequest> CustomerDtoMono, @PathVariable String id)
    {
        return productService.update(CustomerDtoMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id)
    {
        return productService.delete(id);
    }
}