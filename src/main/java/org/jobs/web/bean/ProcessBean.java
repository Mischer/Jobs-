package org.jobs.web.bean;

import org.apache.log4j.Logger;

@Deprecated
public class ProcessBean {
	
	private static Logger log = Logger.getLogger(ProcessBean.class);
	
	public ProcessBean() {
		
    }

	public String homePageAction(){
		if (log.isDebugEnabled()){
			log.debug("Go to HOME page.");
		}
		return "home";
	}
	
}
