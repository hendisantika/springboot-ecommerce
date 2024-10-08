package com.hendisantika.ecommerce.springbootecommerce.service;

import com.hendisantika.ecommerce.springbootecommerce.model.OrderProduct;
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
 * Time: 06:13
 */
@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}
