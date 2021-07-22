package org.generation.UnicornsBackery.controller;

import org.generation.UnicornsBackery.model.Products;
import org.generation.UnicornsBackery.model.Users;
import org.generation.UnicornsBackery.repositories.ProductsRepository;
import org.generation.UnicornsBackery.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductsControllerTest {

    private ProductsRepository productsRepositoryMock = Mockito.mock(ProductsRepository.class);

    @Autowired
    private ProductsController productsController = new ProductsController(productsRepositoryMock);

    @BeforeEach
    void setUp() {
        Products product = new Products();
        product.setIdProducts(1);
        product.setRoute_image("pay.jpg");
        product.setName("pay");
        product.setDescription("Es un pay");
        product.setQuantity(10);
        product.setPrice(150);
        product.setTags("Pay");
        product.setId_category(2);

        List<Products> products = new ArrayList<>();
        products.add(product);
        Mockito.when(productsRepositoryMock.findAll()).thenReturn(products);

    }

    @Test
    void addNewProduct() {
        Products product = new Products();
        product.setRoute_image("pay.jpg");
        product.setName("Pay de Limón");
        product.setDescription("Es un pay");
        product.setQuantity(10);
        product.setPrice(150);
        product.setTags("Pay");
        product.setId_category(2);
        Assertions.assertEquals(productsController.addNewProduct(product),"Saved");
    }



    @Test
    void checkProduct() {
        Assertions.assertEquals(productsController.checkProduct("pay","Pay"),true);
        Assertions.assertEquals(productsController.checkProduct("dona","Donas"),false);
    }
}




//        Products product = new Products();
//        product.setName("Pay de Limón");
//        product.setTags("Pay");
//        Products product2 = new Products();
//        product2.setName("Pay de Limón");
//        product2.setTags("Pastel");
//        Assertions.assertEquals(productsController.checkProduct(product),true);
//        Assertions.assertEquals(productsController.checkProduct(product2),false);