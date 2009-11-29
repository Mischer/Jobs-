package org.jobs.web.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent comp, Object obj) throws ValidatorException {
		boolean isValid = true;

		if ((ctx == null) || (comp == null)) {
			throw new NullPointerException();
		}

		if (!(comp instanceof UIInput)) {
			return;
		}

		if (obj == null) {
			return;
		}
		if (!Pattern.matches(".+@.+\\.[a-z]+", obj.toString())) {
			isValid = false;
		}

		if (!isValid) {
			FacesMessage fmsg = new FacesMessage(MessageFactory.getMessage("errorEmail", null).getDetail());
			fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(fmsg);
		}

	}

}
