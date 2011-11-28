package br.com.otavio.easybroker.rest;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import br.com.otavio.easybroker.exception.ServiceException;

public class BuscaPapeisThreadPoolService extends ScheduledThreadPoolExecutor {
	
	private static final Logger log = Logger.getLogger( BuscaPapeisThreadPoolService.class );
	
	private long delay;
	private TimeUnit unit;
	
	/**
	 * Inicia o threadpool de busca de papeis
	 * 
	 * @param numberOfThreads
	 * @param delay TODO
	 * @param unit
	 * @param command
	 */
	public BuscaPapeisThreadPoolService( final int numberOfThreads, long delay, final TimeUnit unit ) {
		
		super( numberOfThreads );
		
		log.debug( "--> treadpool iniciado" );
		log.debug( "numberOfThreads: " + numberOfThreads );
		log.debug( "delay: " + delay );
		log.debug( "unit: " + unit );
		
		this.delay = delay;
		this.unit = unit;
	}
	
	/**
	 * 
	 * @param command
	 */
	public void addThread( final Runnable command  ) {
		
		log.debug( "thread [" + command + "] adicionada" );
		
		try {
			super.scheduleWithFixedDelay( command, 0, delay, unit );
		}
		catch ( Exception ex ) {
			log.error( ex );
			throw new ServiceException( "could not add runnable (" + command + ") to threadpool" );
		}
	}
	
}
