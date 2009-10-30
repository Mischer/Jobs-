package org.jobs.web.bean;

import org.jobs.persistence.bean.User;
import org.jobs.ws.bean.UsersManager;

/**
 * @author vit
 */
public class LoginBean {

	private String login = "";
	private String pass = "";
	private UsersManager userManager = null;

	public LoginBean() {
		userManager = (UsersManager) FacesUtils.getBean("usersWSClient");
	}

	public String submitAction() {
		User user = userManager.getLogin(login, pass);
		if (user != null) {
			FacesUtils.setSessionAttribute(FacesUtils.USER_ID, user.getId());
			return "home";
		}
		return "fails";
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}
}
