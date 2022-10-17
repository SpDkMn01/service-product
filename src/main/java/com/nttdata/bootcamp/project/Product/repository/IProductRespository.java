package com.nttdata.bootcamp.project.Product.repository;

import com.nttdata.bootcamp.project.Product.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRespository extends ReactiveMongoRepository<Product, String> {
}
