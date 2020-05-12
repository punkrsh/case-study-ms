package com.order.rest.webservices.restfulwebservices.order;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String orderToken;
	private Date targetDate;
	private String orderdesc;
	
	public OrderDetails() {
		
	}

	public OrderDetails(long id, String username, String orderToken, Date targetDate, String orderdesc) {
		super();
		this.id = id;
		this.username = username;
		this.orderToken = orderToken;
		this.targetDate = targetDate;
		this.orderdesc = orderdesc;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		OrderDetails other = (OrderDetails) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrderToken() {
		return orderToken;
	}

	public void setOrderToken(String orderToken) {
		this.orderToken = orderToken;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getOrderdesc() {
		return orderdesc;
	}

	public void setOrderdesc(String orderdesc) {
		this.orderdesc = orderdesc;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", username=" + username + ", orderToken=" + orderToken + ", targetDate="
				+ targetDate + ", orderdesc=" + orderdesc + "]";
	}

	
}