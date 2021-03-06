package org.jobs.web;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.jsf.FacesContextUtils;

public class FacesUtils {

	public static final String USER_ID = "USER_ID";

	private FacesUtils() {
	}

	public static Object getSessionAttribute(String name) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute(name);
	}

	public static void setSessionAttribute(String name, Object value) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute(name, value);
	}

	public static Object getBean(String name) {
		return FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()).getBean(name);
	}

	public String getMessage(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("org.jobs.web", FacesContext.getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
}
