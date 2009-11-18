package org.jobs.web.bean;

import java.io.Serializable;

public abstract class BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String include = null;

	public BaseBean() {
	}

	public String getInclude() {
		if (include == null) {
			include = "/page/user/list.xhtml";
		}
		return include;
	}

	public void setInclude(String include) {
		this.include = include;
	}

}
