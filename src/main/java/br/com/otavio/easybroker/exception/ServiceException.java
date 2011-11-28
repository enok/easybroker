package br.com.otavio.easybroker.exception;

/**
 * Scheduler executor exception
 * 
 * @author enok
 * @since 2011-11
 */
public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3936180328014727634L;

	/**
	 * 
	 */
	public ServiceException() {
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
