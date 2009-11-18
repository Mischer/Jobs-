package org.jobs.web.validator;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		boolean isValid = true;

		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}

		if (!(component instanceof UIInput)) {
			return;
		}

		if (obj == null) {
			return;
		}

		UIComponent confirm = findComponent(FacesContext.getCurrentInstance().getViewRoot(), component.getId() + "_confirm");

		if (confirm == null) {
			return;
		}

		if (!(confirm instanceof UIInput)) {
			return;
		}
		Object confPassword = ((UIInput) confirm).getValue();

		if (confPassword == null || !confPassword.toString().equals(obj.toString())) {
			isValid = false;
		}

		if (!isValid) {
			FacesMessage fmsg = new FacesMessage(MessageFactory.getMessage("errorPasswordConfirm", null).getDetail());
			fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fmsg);
		}
	}

	private UIComponent findComponent(UIComponent component, String id) {
		if (id.equals(component.getId())) {
			return component;
		}
		Iterator<UIComponent> iterator = component.getFacetsAndChildren();
		while (iterator.hasNext()) {
			UIComponent found = findComponent(iterator.next(), id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
}
