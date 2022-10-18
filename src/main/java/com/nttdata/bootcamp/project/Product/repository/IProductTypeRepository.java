package com.nttdata.bootcamp.project.Product.repository;

import com.nttdata.bootcamp.project.Product.entity.ProductType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * <h1>IProductType Repository</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Repository
public interface IProductTypeRepository extends ReactiveMongoRepository<ProductType, String> {
}
