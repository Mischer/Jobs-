package org.jobs.web.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.jobs.persistence.bean.Role;
import org.jobs.persistence.bean.User;
import org.jobs.persistence.dao.impl.DaoImpl.Sort;
import org.jobs.web.FacesUtils;
import org.jobs.ws.bean.UsersManager;

public class UserBean extends BaseBean {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(UserBean.class);
	private UsersManager userManager = null;

	private User user;
	private boolean disable;
	private String sort;
	private Sort sorting;
	private List<User> listUser;

	public UserBean() {
		userManager = (UsersManager) FacesUtils.getBean("usersWSClient");
		listUser = userManager.getUserAllOrder(getSort(), getSorting());
	}

	public List<User> getListUser() {
		return listUser;
		
	}

	public String delete() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null) {
			try {
				userManager.deleteUser(Long.valueOf(id));
				if (log.isDebugEnabled()) {
					log.debug(String.format("Delete user with id = %s ", id));
				}
			} catch (NumberFormatException e) {
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "user.list";
	}

	public String edit() {
		disable = false;
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null) {
			user = userManager.getUser(Long.valueOf(id));
			if (log.isDebugEnabled()) {
				log.debug(String.format("Edit user with id = %s ", user.getId()));
			}
		}
		return "user.edit";
	}

	public String view() {
		disable = true;
		if (log.isDebugEnabled()) {
			log.debug("View user");
		}
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		String id = params.get("id");
		if (id != null) {
			user = userManager.getUser(Long.valueOf(id));
		} else {
			user = new User();
		}
		return "user.edit";
	}

	public String saveUser() {
		if (user.getId() != null) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("Update user with id = %s ", user.getId()));
			}
			userManager.updateUser(user);
		} else {
			if (log.isDebugEnabled()) {
				log.debug(String.format("Save user with login = %s ", user.getUsername()));
			}
			userManager.createUser(user);
		}
		return "user.list";
	}

	public User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public List<SelectItem> getRoles() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Role role : userManager.getRoles()) {
			list.add(new SelectItem(role.getId(), role.getAuthority(), role.getAuthority()));
		}
		return list;
	}
	
	public void sortEvent(ActionEvent event){
		UIComponent component = event.getComponent();
		String sort = component.getAttributes().get("sort").toString();
		listUser = userManager.getUserAllOrder(sort, Sort.ASC);
		FacesContext.getCurrentInstance().responseComplete();
	}

	public boolean isDisable() {
		return disable;
	}

	public void setSort(String sort) {
		if (sort != null && sort.equals(this.sort)) {
			sorting = getSorting().equals(Sort.ASC) ? Sort.DESC : Sort.ASC;
		}
		this.sort = sort;
	}

	public String getSort() {
		return sort;
	}

	public void setSorting(Sort sorting) {
		this.sorting = sorting;
	}

	public Sort getSorting() {
		if (sorting == null) {
			sorting = Sort.ASC;
		}
		return sorting;
	}

	public String loginAction() throws ServletException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("Login application.");
		}
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		return null;
	}

	public String logoutAction() throws ServletException, IOException {
		if (log.isDebugEnabled()) {
			log.debug("Logout application.");
		}
		// ExternalContext context =
		// FacesContext.getCurrentInstance().getExternalContext();
		// RequestDispatcher dispatcher = ((ServletRequest)
		// context.getRequest()).getRequestDispatcher("/j_spring_security_logout");
		// dispatcher.forward((ServletRequest) context.getRequest(),
		// (ServletResponse) context.getResponse());

		return "login";
	}

}
