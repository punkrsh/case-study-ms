package com.order.rest.webservices.restfulwebservices.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderDetails, Long>{
	List<OrderDetails> findByUsername(String username);
}