package com.ina;

import com.ina.controller.ProductController;
import com.ina.entity.Product;
import com.ina.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    static Product mockProduct;
    static Product mockProduct2;
    static List<Product> mockProductList;

    @BeforeAll
    static void setup() {
        mockProduct = Product.builder()
                .productId(1).productName("Car").productDescription("Hyndai").productPrice(3500000.00).location("Hyderabad")
                .build();
        mockProduct2 = Product.builder()
                .productId(2).productName("Bus").productDescription("Eicher").productPrice(8500000.00).location("Hyderabad")
                .build();
        mockProductList = List.of(mockProduct, mockProduct2);
    }

    @Test
    void testGetAllProducts() {
        Mockito.when(productService.findAll()).thenReturn(mockProductList);

        List<Product> result = productController.getAllProducts();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, mockProductList);
    }

    @Test
    void testFetchProductById() {
        Mockito.when(productService.findById(Mockito.any())).thenReturn(Optional.ofNullable(mockProduct));

        Optional<Product> result = productController.fetchProductById(1);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(mockProduct, result.get());
    }

    @Test
    void testFetchProductByProductName() {
        Mockito.when(productService.findByName(Mockito.any())).thenReturn(Optional.of(mockProduct));

        Optional<Product> result = productController.fetchProductByProductName("Car");

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(mockProduct, result.get());
    }

    @Test
    void testAddProduct() {
        Mockito.when(productService.save(Mockito.any(Product.class))).thenReturn(mockProduct);

        Product result = productController.addProduct(mockProduct);

        Assertions.assertEquals(mockProduct, result);
        Assertions.assertTrue(result.getProductId().equals(mockProduct.getProductId()));
    }

    @Test
    void testUpdateProduct() {
        Mockito.when(productService.update(Mockito.any(Product.class))).thenReturn(mockProduct);

        Product result = productController.updateProduct(mockProduct);

        Assertions.assertEquals(mockProduct, result);
    }

    @Test
    void testDeleteProduct() {
        Mockito.doNothing().when(productService).delete(Mockito.any(Product.class));

        productController.deleteProduct(mockProduct);

        Mockito.verify(productService, Mockito.times(1)).delete(mockProduct);
    }


}
