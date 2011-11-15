package br.com.otavio.easybroker.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 4559300321616973852L;

	public void testeMessage(ActionEvent event){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Titulo", "Texto desejado"));
	}
	
}
