package org.jobs.web.admin.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.jobs.persistence.bean.User;
import org.jobs.web.FacesUtils;
import org.jobs.web.bean.UserBean;
import org.jobs.ws.bean.UsersManager;

public class AdminBean {

	private static Logger log = Logger.getLogger(UserBean.class);
	private UsersManager userManager = null;

	private User user = new User();
	private Long group;

	public AdminBean() {
		userManager = (UsersManager) FacesUtils.getBean("usersWSClient");
	}


	public String edit() {
		if (log.isDebugEnabled()) {
			log.debug(String.format("Edit user with id = %s ", user.getId()));
		}
		return "user.edit";
	}

	public String view() {
		if (log.isDebugEnabled()) {
			log.debug(String.format("View user with id = %s ", user.getId()));
		}
		return "user.view";
	}

	public String saveUser() {
		// user.setGroup(userManager.getGroup(group));
		if (user.getId() != null) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("Update user with id = %s ", user.getId()));
			}
			userManager.updateUser(user);
		} else {
			if (log.isDebugEnabled()) {
				// log.debug(String.format("Save user with login = %s ",
				// user.getLogin()));
			}
			userManager.createUser(user);
		}
		return "user.view";
	}


	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setGroup(Long group) {
		this.group = group;
	}

	public Long getGroup() {
		return group;
	}

}
