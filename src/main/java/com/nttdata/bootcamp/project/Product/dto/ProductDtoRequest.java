package com.nttdata.bootcamp.project.Product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoRequest {
    private String productTypeId;
    private String description;
}
