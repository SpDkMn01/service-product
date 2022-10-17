package com.nttdata.bootcamp.project.Product.repository;

import com.nttdata.bootcamp.project.Product.entity.ProductType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends ReactiveMongoRepository<ProductType, String> {
}
