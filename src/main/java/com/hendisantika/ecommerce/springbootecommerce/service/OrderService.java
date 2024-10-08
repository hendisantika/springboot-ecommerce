package com.hendisantika.ecommerce.springbootecommerce.service;

import com.hendisantika.ecommerce.springbootecommerce.model.Order;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-26
 * Time: 06:14
 */
@Validated
public interface OrderService {

    @NotNull
    Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}
