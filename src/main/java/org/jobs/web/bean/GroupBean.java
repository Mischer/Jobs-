package org.jobs.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.jobs.persistence.bean.Group;
import org.jobs.web.FacesUtils;
import org.jobs.ws.bean.UsersManager;

public class GroupBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(GroupBean.class);

	private UsersManager userManager = null;

	public GroupBean() {
		userManager = (UsersManager) FacesUtils.getBean("usersWSClient");
	}

	public List<SelectItem> getGroups() {
		if (log.isDebugEnabled()) {
			log.debug("Get all group.");
		}
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Group group : userManager.getGroupAll()) {
			items.add(new SelectItem(group, group.getName(), group.getDescription()));
		}
		return items;
	}

}
