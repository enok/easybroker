package br.com.otavio.easybroker.rest;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import br.com.otavio.easybroker.exception.ServiceException;
import br.com.otavio.easybroker.rest.model.Papel;

public class ConsultaPapeisThreadPoolService extends ScheduledThreadPoolExecutor {
	
	private static final Logger log = Logger.getLogger( ConsultaPapeisThreadPoolService.class );
	
	private long delay;
	private TimeUnit unit;
	private List< Papel > papeis;
	
	/**
	 * Inicia o threadpool de busca de papeis
	 * 
	 * @param numberOfThreads
	 * @param delay TODO
	 * @param unit
	 * @param command
	 */
	public ConsultaPapeisThreadPoolService( final int numberOfThreads, long delay, final TimeUnit unit ) {
		
		super( numberOfThreads );
		
		log.debug( "--> treadpool iniciado" );
		log.debug( "numberOfThreads: " + numberOfThreads );
		log.debug( "delay: " + delay );
		log.debug( "unit: " + unit );
		
		this.delay = delay;
		this.unit = unit;
	}
	
	/**
	 * Init the threads
	 */
	public void initThreads() {
		
		addThread( new ConsultaPapeisThread( "consulta-papeis", this, new RestClient() ) );
	}
	
	/**
	 * 
	 * @param command
	 */
	private void addThread( final Runnable command  ) {
		
		log.debug( "thread [" + command + "] adicionada" );
		
		try {
			super.scheduleWithFixedDelay( command, 0, delay, unit );
		}
		catch ( Exception ex ) {
			log.error( ex );
			throw new ServiceException( "could not add runnable (" + command + ") to threadpool" );
		}
	}

	// getters 'n setters

	/**
	 * @return the papeis
	 */
	public List<Papel> getPapeis() {
		return papeis;
	}

	/**
	 * @param papeis the papeis to set
	 */
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
}
