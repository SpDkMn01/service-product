package com.nttdata.bootcamp.project.Product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <h1>ProductTypeDto</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDto {
    private String id;
    private String description;
}
