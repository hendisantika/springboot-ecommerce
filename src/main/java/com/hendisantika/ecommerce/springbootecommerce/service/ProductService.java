package com.hendisantika.ecommerce.springbootecommerce.service;

import com.hendisantika.ecommerce.springbootecommerce.model.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-26
 * Time: 06:15
 */
@Validated
public interface ProductService {

    @NotNull
    Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);
}
