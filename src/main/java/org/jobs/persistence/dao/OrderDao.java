package org.jobs.persistence.dao;

import java.util.List;

import org.jobs.persistence.bean.Order;

public interface OrderDao extends Dao<Order> {
	
	List<Order> getAll();

	Order get(Long id);

}
