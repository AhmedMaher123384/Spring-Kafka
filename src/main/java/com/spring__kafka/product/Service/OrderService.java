package com.spring__kafka.product.Service;

import com.spring__kafka.product.Model.Order;
import com.spring__kafka.product.Model.Product;
import com.spring__kafka.product.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener( topics = "topic-product" , groupId = "group_id")
    public void Consumer(Product product){
        System.out.println("consumed Message" + product);
        Order order= new Order();
        order.setProductName(product.getName());
        order.setQuantity(2);
        order.setPrice(product.getPrice());
        orderRepository.save(order);
    }

}
