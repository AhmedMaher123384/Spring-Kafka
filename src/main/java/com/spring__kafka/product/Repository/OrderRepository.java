package com.spring__kafka.product.Repository;


import com.spring__kafka.product.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
