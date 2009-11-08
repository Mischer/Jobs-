package org.jobs.web.bean;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.jobs.web.FacesUtils;
import org.jobs.ws.bean.UsersManager;

/**
 * @author vit
 */
public class LoginBean {
	private static Logger log = Logger.getLogger(LoginBean.class);
	private String login = "";
	private String pass = "";
	private UsersManager userManager = null;

	public LoginBean() {
		userManager = (UsersManager) FacesUtils.getBean("usersWSClient");
	}

	public String submitAction() throws ServletException, IOException {
		// User user = userManager.getLogin(login, pass);
		// ExternalContext context =
		// FacesContext.getCurrentInstance().getExternalContext();
		// RequestDispatcher dispatcher = ((ServletRequest)
		// context.getRequest()).getRequestDispatcher("/j_spring_security_check");
		// dispatcher.forward((ServletRequest) context.getRequest(),
		// (ServletResponse) context.getResponse());
		// FacesContext.getCurrentInstance().responseComplete();
		return "home";
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
