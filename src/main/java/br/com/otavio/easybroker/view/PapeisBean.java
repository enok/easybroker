package br.com.otavio.easybroker.view;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.otavio.easybroker.rest.ConsultaPapeisThreadPoolService;

/**
 * 
 *
 */
@Component("papeisBean")
@Scope("session")
public class PapeisBean implements Serializable {

	private static final long serialVersionUID = 7084477651284080296L;

	private ConsultaPapeisThreadPoolService consultaPapeisThreadPoolService;

	/**
	 * @return the consultaPapeisThreadPoolService
	 */
	public ConsultaPapeisThreadPoolService getConsultaPapeisThreadPoolService() {
		return consultaPapeisThreadPoolService;
	}

	/**
	 * @param consultaPapeisThreadPoolService
	 *            the consultaPapeisThreadPoolService to set
	 */
	public void setConsultaPapeisThreadPoolService(
			ConsultaPapeisThreadPoolService consultaPapeisThreadPoolService) {
		this.consultaPapeisThreadPoolService = consultaPapeisThreadPoolService;
	}
	
	public String getNomeUsuario() {
		
		Object nomeUsuario = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nomeUsuario");
		
		String result = null;
		if ( nomeUsuario != null ) {
			result = nomeUsuario.toString();
		}
		
		return result;
	}
	
	public String getMensagem() {
		
		Object mensagem = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mensagem");
		
		String result = null;
		if ( mensagem != null ) {
			result = mensagem.toString();
		}
		
		return result;
	}
	
}
