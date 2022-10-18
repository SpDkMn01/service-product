package com.nttdata.bootcamp.project.Product.repository;

import com.nttdata.bootcamp.project.Product.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * <h1>IProduct Repository</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Repository
public interface IProductRespository extends ReactiveMongoRepository<Product, String> {
}
