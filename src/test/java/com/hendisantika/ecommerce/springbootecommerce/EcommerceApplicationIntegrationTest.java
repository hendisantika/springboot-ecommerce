package com.hendisantika.ecommerce.springbootecommerce;

import com.hendisantika.ecommerce.springbootecommerce.controller.OrderController;
import com.hendisantika.ecommerce.springbootecommerce.controller.ProductController;
import com.hendisantika.ecommerce.springbootecommerce.dto.OrderProductDto;
import com.hendisantika.ecommerce.springbootecommerce.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-26
 * Time: 06:24
 */
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
                .hasSize(9);

        assertThat(products, hasItem(hasProperty("name", is("Samsung TV Set"))));
        assertThat(products, hasItem(hasProperty("name", is("Game Console"))));
        assertThat(products, hasItem(hasProperty("name", is("Sofa"))));
        assertThat(products, hasItem(hasProperty("name", is("Ice Cream"))));
        assertThat(products, hasItem(hasProperty("name", is("Marjan"))));
        assertThat(products, hasItem(hasProperty("name", is("iPhone 16 Pro Max"))));
        assertThat(products, hasItem(hasProperty("name", is("Watch"))));
        assertThat(products, hasItem(hasProperty("name", is("MI TV Set"))));
        assertThat(products, hasItem(hasProperty("name", is("Brompton"))));
    }

//    @Test
//    public void givenPostOrder_whenBodyRequestMatcherJson_thenResponseContainsEqualObjectProperties() {
//        final ResponseEntity<Order> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/orders", prepareOrderForm(), Order.class);
//        Order order = postResponse.getBody();
//        Assertions
//                .assertThat(postResponse.getStatusCode())
//                .isEqualByComparingTo(HttpStatus.CREATED);
//
//        assertThat(order, hasProperty("status", is("PAID")));
//        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(2))));
//    }

    private OrderController.OrderForm prepareOrderForm() {
        OrderController.OrderForm orderForm = new OrderController.OrderForm();
        OrderProductDto productDto = new OrderProductDto();
        productDto.setProduct(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100"));
        productDto.setQuantity(2);
        orderForm.setProductOrders(Collections.singletonList(productDto));

        return orderForm;
    }
}
