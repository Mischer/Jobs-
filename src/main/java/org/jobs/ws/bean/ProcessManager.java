package org.jobs.ws.bean;

import java.util.List;

import javax.jws.WebService;

import org.jobs.persistence.bean.Order;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@WebService
@Transactional(readOnly = true)
public interface ProcessManager {

	List<Order> getOrderAll();

	Order getOrder(Long orderId);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Order createOrder(Order order);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	Order updateOrder(Order order);

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	void deleteOrder(Long orderId) throws Exception;

}
