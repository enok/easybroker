package br.com.otavio.easybroker.view;

import java.io.Serializable;

import br.com.otavio.easybroker.rest.ConsultaPapeisThreadPoolService;

/**
 * 
 *
 */
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

}
