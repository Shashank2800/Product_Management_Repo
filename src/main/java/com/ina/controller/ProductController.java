package com.ina.controller;

import com.ina.constant.Constants;
import com.ina.entity.Product;
import com.ina.model.ProductModel;
import com.ina.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.PRODUCT_MAPPING)
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Optional<Product> fetchProductById(@RequestParam Integer productId) {
        return productService.findById(productId);
    }

    @PostMapping
    public Optional<Product> fetchProductByIdUsingRequestBody(@RequestBody ProductModel productModel) {
        return productService.findById(productModel.getProductId());
    }


    @GetMapping(Constants.FETCH_BY_ID)
    public Optional<Product> fetchProductByIdUsingPathVariable(@PathVariable Integer productId) {
        return productService.findById(productId);
    }

    @PostMapping(Constants.FETCH_BY_NAME)
    public Optional<Product> fetchProductByProductName(@PathVariable String productName) {
        return productService.findByName(productName);

    }

    @PostMapping(Constants.ADD_PRODUCT)
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping(Constants.FETCH_ALL_PRODUCTS)
    public List<Product> getAllProducts() {
        return productService.findAll();

    }

    @PutMapping(Constants.UPDATE_PRODUCT)
    public Product updateProduct(@RequestBody Product product) {
        return productService.update(product);

    }

    @DeleteMapping(Constants.DELETE_PRODUCT)
    public void deleteProduct(@RequestBody Product product) {
        productService.delete(product);

    }

}
