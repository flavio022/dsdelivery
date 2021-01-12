package com.devsuperior.dsdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.dto.ProductDto;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.Product;
import com.devsuperior.dsdelivery.entities.enums.OrderStatus;
import com.devsuperior.dsdelivery.repositories.OrderRepository;
import com.devsuperior.dsdelivery.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository Productrepository;
 
	@Transactional
	public List<OrderDto> findAll() {
		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
	@Transactional
	public OrderDto insert(OrderDto dto) {
		Order order = new Order(null,dto.getAddress(),dto.getLatitude(),dto.getLatitude(),Instant.now(),OrderStatus.PENDENTE, null);
		for (ProductDto p : dto.getProducts()) {
			Product product = Productrepository.getOne(p.getId());
			order.getProducts().add(product);
		}

		order = orderRepository.save(order);
		return new OrderDto(order);
	}
	@Transactional
	public OrderDto setDelivery(Long id) {
		Order order = orderRepository.getOne(id);
		order.setStatus(OrderStatus.QUITADO);
		order = orderRepository.save(order);
		return new OrderDto(order);
	}
}