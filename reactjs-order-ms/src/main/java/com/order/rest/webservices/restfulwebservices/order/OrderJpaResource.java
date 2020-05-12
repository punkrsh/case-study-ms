package com.order.rest.webservices.restfulwebservices.order;

import java.net.URI;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class OrderJpaResource {

	@Autowired
	private OrderJpaRepository OrderJpaRepository;
	
	@GetMapping("/order/users/{username}/orders")
	public List<OrderDetails> getAllTodos(@PathVariable String username) {
		return OrderJpaRepository.findByUsername(username);
		// return todoService.findAll();
	}
	
	@GetMapping("/order/users/{username}")
	public ResponseEntity<OrderDetails> initiateOrder(@PathVariable String username,
			HttpServletRequest req, HttpSession session,HttpServletResponse res) {

		
		String token = generateToken();
		System.out.println("ordertoken: " + token +" : "+ username);
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderToken(token);
		orderDetails.setUsername(username);
		
		OrderDetails createdOrder = OrderJpaRepository.save(orderDetails);
		System.out.println("Temp order token created successfully!" +createdOrder.toString());
		
		return new ResponseEntity<OrderDetails>(createdOrder, HttpStatus.OK);
	}


	@PostMapping("/order/users/{username}")
	public ResponseEntity<Void> createOrder(@PathVariable String username, @RequestBody OrderDetails orderDetails,
			HttpServletRequest req, HttpSession session) {

		System.out.println("In create Order: "+orderDetails.getOrderToken());
		
		OrderDetails orderDetailsFromDB = OrderJpaRepository.getOne(orderDetails.getId());
		
		boolean isValidOrderToken = validateOrderToken(orderDetails.getOrderToken(),orderDetailsFromDB.getOrderToken());
		if(!isValidOrderToken) {
			
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		
		orderDetails.setUsername(username);
		orderDetails.setTargetDate(new Date());
		
		OrderDetails createdOrder = OrderJpaRepository.save(orderDetails);

		// Location
		// Get current resource url
		// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdOrder.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}

	private boolean validateOrderToken(String orderToken, Object token_in_session) {
		

		if(orderToken.equalsIgnoreCase((String)token_in_session)) {
			return true;
		}
		return false;
	}


	public static String generateToken() {

		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		StringBuilder builder = new StringBuilder();

		int count = 27;
		while (count-- != 0) {

			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}

		System.out.println(builder.toString());
		return builder.toString();

	}

	
}
