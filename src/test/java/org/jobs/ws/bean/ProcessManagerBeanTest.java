package org.jobs.ws.bean;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.jobs.JobsTest;
import org.jobs.persistence.bean.Client;
import org.jobs.persistence.bean.Order;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProcessManagerBeanTest {
	
	private static ProcessManager processManager;
	private static Long orderId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		processManager = (ProcessManager) JobsTest.getContext().getBean("processManager");
	}

	@Test
	public void testCreateOrder() {
		Client client = new Client();
		client.setAddress("address");
		client.setBirthday(new Date());
		client.setFirstName("firstName");
		client.setLastName("lastName");
		client.setMiddleName("middleName");
		
		Order order = new Order();
		order.setStartDate(new Date());
		order.setClient(client);
		
		Order rez = processManager.createOrder(order);
		Assert.assertNotNull(rez.getId());
	}

	@Test
	public void testGetOrderAll() {
		List<Order> order = processManager.getOrderAll();
		orderId = order.get(0).getId();
		Assert.assertFalse(order.isEmpty());
	}

	@Test
	public void testUpdateOrder() {
		Order order = processManager.getOrder(orderId);
		order.getClient().setFirstName("test");
		Order rez = processManager.updateOrder(order);
		Assert.assertEquals(rez.getClient().getFirstName(), "test");		
	}

	@Test
	public void testGetOrder() {
		Order order = processManager.getOrder(orderId);
		Assert.assertNotNull(order);
	}

	@Test
	public void testDeleteOrder() {
		try {
	        processManager.deleteOrder(orderId);
			Order order = processManager.getOrder(orderId);
			Assert.assertNull(order);
        } catch (Exception e) {
        	fail(e.getMessage());
        }
	}
}
