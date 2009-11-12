package org.jobs.web.bean;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.jobs.web.FacesUtils;
import org.jobs.ws.bean.UsersManager;
import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

/**
 * @author vit
 */
public class LoginBean implements UserDetailsService {
	private static Logger log = Logger.getLogger(LoginBean.class);

	public LoginBean() {

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
		//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		//RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_logout");
		//dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		
		return "login";
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, DataAccessException {
		UsersManager usersManager = (UsersManager) FacesUtils.getBean("usersWSClient");
		UserDetails details = usersManager.getUserByLogin(login);
		return details;
	}

}
