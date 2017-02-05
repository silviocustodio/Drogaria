package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	public static void addSuccessMessage(String message){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
	
	public static void addErrorMessage(String message){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
	
	

}
