package org.jobs.web.bean;

import javax.faces.context.FacesContext;

import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.web.jsf.FacesContextUtils;

public class FacesUtils {

	public static final String USER_ID = "USER_ID";

	private FacesUtils() {

	}

	public static Object getSessionAttribute(String name) {
		StandardSessionFacade session = (StandardSessionFacade) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute(name);
	}

	public static void setSessionAttribute(String name, Object value) {
		StandardSessionFacade session = (StandardSessionFacade) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute(name, value);
	}

	public static Object getBean(String name) {
		return FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()).getBean(name);
	}
}
