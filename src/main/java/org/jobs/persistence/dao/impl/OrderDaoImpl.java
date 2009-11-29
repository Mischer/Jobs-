package org.jobs.persistence.dao.impl;

import java.util.List;

import org.jobs.persistence.bean.Order;
import org.jobs.persistence.dao.OrderDao;

public class OrderDaoImpl extends DaoImpl<Order> implements OrderDao {

	public OrderDaoImpl() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getAll() {
		return getHibernateTemplate().find("from Order");
	}

	@Override
	public Order get(Long id) {
		return get(Order.class, id);
	}

}
