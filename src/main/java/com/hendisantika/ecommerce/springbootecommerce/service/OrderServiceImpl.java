package com.hendisantika.ecommerce.springbootecommerce.service;

import com.hendisantika.ecommerce.springbootecommerce.dto.OrderProductDto;
import com.hendisantika.ecommerce.springbootecommerce.model.Order;
import com.hendisantika.ecommerce.springbootecommerce.model.OrderProduct;
import com.hendisantika.ecommerce.springbootecommerce.model.OrderStatus;
import com.hendisantika.ecommerce.springbootecommerce.repository.OrderProductRepository;
import com.hendisantika.ecommerce.springbootecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ecommerce
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-26
 * Time: 06:15
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderProductRepository orderProductRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductService productService,
                            OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public Order createOrderWithProducts(List<OrderProductDto> productDtos) {
        // Validate all products exist

        productDtos.forEach(dto -> productService.getProduct(dto.getProduct().getId()));

        // Create order
        Order order = new Order();
        order.setStatus(OrderStatus.UNPAID.name());
        order.setDateCreated(LocalDate.now());

        order = orderRepository.save(order);

        // Create associated OrderProducts
        List<OrderProduct> orderProducts = new ArrayList<>();

        for (OrderProductDto dto : productDtos) {
            OrderProduct op = new OrderProduct(
                    order,
                    productService.getProduct(dto.getProduct().getId()),
                    dto.getQuantity()
            );
            orderProducts.add(op);
        }

        orderProductRepository.saveAll(orderProducts);
        order.setOrderProducts(orderProducts);
        return order;
    }

}