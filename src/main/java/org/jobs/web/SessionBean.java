package org.jobs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

public class SessionBean implements Serializable{
	
    private static final long serialVersionUID = 1L;
    private String currentLocale;
    
	public String getCurrentLocale() {
    	return currentLocale;
    }

	public void setCurrentLocale(String currentLocale) {
    	this.currentLocale = currentLocale;
    }

	public List<SelectItem> getLocale(){
		List<SelectItem> list = new ArrayList<SelectItem>();
		list.add(new SelectItem("ru","Russian"));
		list.add(new SelectItem("en","English"));
		return list;
	}
	
	public void changeLocaleListener(ValueChangeEvent event){
		String locale = event.getNewValue().toString();
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot viewRoot = context.getViewRoot();
		viewRoot.setLocale(new Locale(locale));
		context.renderResponse();
	}

}
