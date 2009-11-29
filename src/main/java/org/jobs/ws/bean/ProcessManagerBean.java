package org.jobs.ws.bean;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.jobs.persistence.bean.Order;
import org.jobs.persistence.dao.OrderDao;

@SuppressWarnings("unused")
@WebService(serviceName = "ProcessManager", endpointInterface = "org.jobs.ws.bean.ProcessManager")
public class ProcessManagerBean implements ProcessManager {

	private static Logger log = Logger.getLogger(ProcessManagerBean.class);
	
	private OrderDao orderDao;
	
	@WebMethod(exclude=true)
	public void setOrderDao(OrderDao orderDao) {
    	this.orderDao = orderDao;
    }

	@Override
	@WebMethod
	public Order createOrder(Order order) {
		orderDao.create(order);
		return order;
	}

	@Override
	@WebMethod
	public void deleteOrder(Long orderId) throws Exception {
		Order order = orderDao.get(orderId);
		orderDao.delete(order);
	}

	@Override
	@WebMethod
	public List<Order> getOrderAll() {
		return orderDao.getAll();
	}

	@Override
	@WebMethod
	public Order updateOrder(Order order) {
		orderDao.update(order);
		return order;
	}

	@Override
	@WebMethod
    public Order getOrder(Long orderId) {
		return orderDao.get(orderId);
    }

}
