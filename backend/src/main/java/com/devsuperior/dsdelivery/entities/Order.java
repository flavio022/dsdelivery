package com.devsuperior.dsdelivery.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.devsuperior.dsdelivery.entities.enums.OrderStatus;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private Double latitude;
	private Instant moment;
	private OrderStatus status;
	private Double total;
	
	private Set<Product> products = new HashSet<>();
	
	public Order() {
		
	}
	public Order(Long id,String address,Double latitude,Instant moment,OrderStatus status,Double total) {
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.moment = moment;
		this.status = status;
		this.total = total;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Set<Product> getProducts() {
		return products;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}