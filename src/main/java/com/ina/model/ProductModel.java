package com.ina.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class ProductModel {
    private Integer productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private String location;
}
