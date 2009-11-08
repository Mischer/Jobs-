package org.jobs.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.Authentication;
import org.springframework.security.ui.TargetUrlResolverImpl;
import org.springframework.security.ui.savedrequest.SavedRequest;

public class ExTargetUrlResolver extends TargetUrlResolverImpl {

	private String url;

	@Override
	public String determineTargetUrl(SavedRequest savedRequest, HttpServletRequest request, Authentication auth) {
		String sessionId = request.getSession().getId();
		return url + ";jsessionid=" + sessionId;
	}
	
	public void setUrl(String url) {
	    this.url = url;
    }
}
