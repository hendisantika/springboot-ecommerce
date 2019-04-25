package com.hendisantika.ecommerce.springbootecommerce;

import com.hendisantika.ecommerce.springbootecommerce.controller.OrderController;
import com.hendisantika.ecommerce.springbootecommerce.controller.ProductController;
import com.hendisantika.ecommerce.springbootecommerce.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-26
 * Time: 06:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootEcommerceApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EcommerceApplicationIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private ProductController productController;

    @Autowired
    private OrderController orderController;

    @Test
    public void contextLoads() {
        Assertions
                .assertThat(productController)
                .isNotNull();
        Assertions
                .assertThat(orderController)
                .isNotNull();
    }

    @Test
    public void givenGetProductsApiCall_whenProductListRetrieved_thenSizeMatchAndListContainsProductNames() {
        ResponseEntity<Iterable<Product>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/products", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Product>>() {
        });
        Iterable<Product> products = responseEntity.getBody();
        Assertions
                .assertThat(products)
                .hasSize(7);

        assertThat(products, hasItem(hasProperty("name", is("TV Set"))));
        assertThat(products, hasItem(hasProperty("name", is("Game Console"))));
        assertThat(products, hasItem(hasProperty("name", is("Sofa"))));
        assertThat(products, hasItem(hasProperty("name", is("Icecream"))));
        assertThat(products, hasItem(hasProperty("name", is("Beer"))));
        assertThat(products, hasItem(hasProperty("name", is("Phone"))));
        assertThat(products, hasItem(hasProperty("name", is("Watch"))));
    }
}
