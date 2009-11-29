package org.jobs.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.jobs.persistence.bean.Order;
import org.jobs.web.FacesUtils;
import org.jobs.ws.bean.ProcessManager;

public class OrderBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	private boolean disable = false;
	private String sort;
	private String sorting;
	private Order order;
	private List<Order> listOrder;
	private ProcessManager processManager = null;

	public OrderBean() {
		processManager = (ProcessManager) FacesUtils.getBean("processWSClient");
	}
	
	public Order getOrder() {
		if (order == null) {
			order = new Order();
		}
		return order;
	}
	
	public boolean isDisable(){
		return disable;
	}
	
	public String view(){
		return "order.list";
	}

	public String edit(){
		return "order.list";
	}

	public String delete(){
		return "order.list";
	}

	public String saveOrder(){
		processManager.createOrder(order);
		return "order.list";
	}
	
	public String searchAction(){
		
		return "order.list";
	}
	
	public List<Order> getListOrder(){
		if (listOrder == null){
			listOrder = new ArrayList<Order>(); 
		}
		return listOrder;
	}
	
	public void sortEvent(ActionEvent event){
		
	}

	public String getSort() {
    	return sort;
    }

	public void setSort(String sort) {
    	this.sort = sort;
    }

	public String getSorting() {
    	return sorting;
    }

	public void setSorting(String sorting) {
    	this.sorting = sorting;
    }
}
