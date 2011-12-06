package br.com.otavio.easybroker.rest;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.otavio.easybroker.rest.model.Papel;

/**
 *
 */
public class ConsultaPapeisThread extends Thread {
	
	private static final Logger log = Logger.getLogger( ConsultaPapeisThread.class );
	
	private ConsultaPapeisThreadPoolService consultaPapeisThreadPoolService;
	private RestClient restClient;
	
	public ConsultaPapeisThread( final String threadName, final ConsultaPapeisThreadPoolService consultaPapeisThreadPoolService, final RestClient restClient ) {
		super( threadName );
		this.consultaPapeisThreadPoolService = consultaPapeisThreadPoolService;
		this.restClient = restClient;
	}
	
	@Override
	public void run() {
		
		log.debug( "running thread: " + getName() );
		
		List< Papel > papeis = restClient.getPapeis( getPapeis() );
		log.debug( "papeis size: " + papeis.size() );
		
		consultaPapeisThreadPoolService.setPapeis( papeis );
	}

	/**
	 * TODO implementar a busca no banco
	 * @return
	 */
	private String[] getPapeis() {
		return new String[] { "PETR4", "VALE5", "ITEC3" };
	}

	// getters 'n setters
	
	/**
	 * @return the restClient
	 */
	public RestClient getRestClient() {
		return restClient;
	}

	/**
	 * @param restClient the restClient to set
	 */
	public void setRestClient(RestClient restClient) {
		this.restClient = restClient;
	}
	
}
