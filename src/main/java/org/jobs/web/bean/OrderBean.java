package org.jobs.web.bean;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.jobs.persistence.bean.Order;
import org.jobs.web.FacesUtils;
import org.jobs.ws.bean.ProcessManager;

public class OrderBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(OrderBean.class);

	private boolean disable = false;
	private String sort;
	private String sorting;
	private Order order;
	private List<Order> listOrder;
	private ProcessManager processManager = null;

	public OrderBean() {
		processManager = (ProcessManager) FacesUtils.getBean("processWSClient");
		listOrder = processManager.getOrderAll();
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public Order getOrder() {
		if (order == null) {
			order = new Order();
		}
		return order;
	}

	public boolean isDisable() {
		return disable;
	}

	public String view() {
		disable = true;
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null) {
			order = processManager.getOrder(Long.valueOf(id));
			if (log.isDebugEnabled()) {
				log.debug(String.format("Edit order with id = %s ", order.getId()));
			}
		}
		return "order.edit";
	}

	public String edit() {
		disable = false;
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null) {
			order = processManager.getOrder(Long.valueOf(id));
			if (log.isDebugEnabled()) {
				log.debug(String.format("Edit order with id = %s ", order.getId()));
			}
		}
		return "order.edit";
	}

	public String delete() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null) {
			try {
				processManager.deleteOrder(Long.valueOf(id));
				if (log.isDebugEnabled()) {
					log.debug(String.format("Delete order with id = %s ", id));
				}
			} catch (NumberFormatException e) {
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "order.list";
	}

	public String saveOrder() {
		Order rez = processManager.createOrder(order);
		return "order.list";
	}

	public String searchAction() {

		return "order.list";
	}

	public void sortEvent(ActionEvent event) {

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
