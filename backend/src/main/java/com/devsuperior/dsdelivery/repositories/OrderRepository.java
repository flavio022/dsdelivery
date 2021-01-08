package com.devsuperior.dsdelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.Product;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
