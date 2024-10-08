package com.hendisantika.ecommerce.springbootecommerce.controller;

import com.hendisantika.ecommerce.springbootecommerce.model.Product;
import com.hendisantika.ecommerce.springbootecommerce.service.ProductService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-26
 * Time: 06:21
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
}
