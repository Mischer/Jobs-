package org.jobs.web.bean;

import java.util.ArrayList;
import java.util.List;

import org.jobs.persistence.bean.Order;

public class OrderBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private Order order;

	public OrderBean() {

	}

	public Order getOrder() {
		if (order == null) {
			order = new Order();
		}
		return order;
	}
	
	public boolean isDisable(){
		return false;
	}
	
	public String saveOrder(){
		
		return "order.list";
	}
	
	public List<Order> getListOrder(){
		List<Order> orders = new ArrayList<Order>(); 
		return orders;
	}
}
