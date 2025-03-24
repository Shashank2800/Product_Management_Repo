package com.ina;


import com.ina.entity.Product;
import com.ina.repository.ProductRepository;
import com.ina.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {


    @InjectMocks
    ProductServiceImpl productServiceImpl;
    @Mock
    ProductRepository productRepository;

    @Test
    void whenNewProductIsAdded() throws Exception {
        Product mockproduct = Product.builder()
                        .productId(11)
                        .productName("Cycle")
                        .productDescription("Gear")
                        .productPrice(15000.00)
                        .location("Delhi")
                        .build();

        Mockito.when(productServiceImpl.save(Mockito.any())).thenReturn(mockproduct);

        Product addedProduct=productRepository.save(mockproduct);

        //Test added Product == mock product
        Assertions.assertEquals(addedProduct,mockproduct);
        Assertions.assertEquals(addedProduct.getProductId(),mockproduct.getProductId());
        Assertions.assertTrue(addedProduct.getProductName().equals(mockproduct.getProductName()));


        System.out.println(addedProduct);
        System.out.println(mockproduct);
        System.out.println("Hello");
    }

    @Test
    void whenProductIdFindingById() throws Exception {
        Product mockproduct = Product.builder()
                .productId(11)
                .productName("Cycle")
                .productDescription("Gear")
                .productPrice(15000.00)
                .location("Delhi")
                .build();

        Mockito.when(productServiceImpl.findById(Mockito.any())).thenReturn(Optional.ofNullable(mockproduct));

        Optional<Product> findedProductById=productRepository.findById(11);

        //Test finded by id product == mock product
        Assertions.assertTrue(findedProductById.isPresent());
        Assertions.assertEquals(findedProductById.get(),mockproduct);
        Assertions.assertEquals(findedProductById.get().getProductId(),mockproduct.getProductId());

    }

    @Test
    void whenFindingAllProducts() throws Exception {
        Product product1=Product.builder().productId(11).productName("Cycle").productDescription("Gear").productPrice(15000.00).build();
        Product product2=Product.builder().productId(12).productName("Truck").productDescription("Heavy").productPrice(5550000.00).build();
        Product product3=Product.builder().productId(13).productName("Lorry").productDescription("Light").productPrice(7500000.00).build();
        List<Product> mockProductList= Arrays.asList(product1,product2,product3);

        Mockito.when(productServiceImpl.findAll()).thenReturn(mockProductList);

        List<Product> findedProductList=productRepository.findAll();

        //Test findedProductList==mockProductList
        Assertions.assertTrue(findedProductList.size()==mockProductList.size());
        Assertions.assertEquals(findedProductList,mockProductList);
        Assertions.assertTrue(findedProductList.contains(product1));
        Assertions.assertTrue(findedProductList.contains(product2));

    }

    @Test
    void whenUpdateProduct() throws Exception {
        Product mockProduct=Product.builder().productId(11).productName("Cycle").productDescription("Gear").build();

        Mockito.when(productServiceImpl.save(Mockito.any())).thenReturn(mockProduct);

        Product updatedProduct=productRepository.save(mockProduct);

        Assertions.assertEquals(updatedProduct,mockProduct);

    }

    @Test
    void whenDeleteProduct() throws Exception {
        Product mockProduct=Product.builder().productId(11).productName("Cycle").productDescription("Gear").build();

        Mockito.doNothing().when(productRepository).delete(mockProduct);
        productServiceImpl.delete(mockProduct);
        Mockito.verify(productRepository, Mockito.times(1)).delete(mockProduct);

    }
}
