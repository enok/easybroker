package br.com.otavio.easybroker.rest;

import org.apache.log4j.Logger;

/**
 * Thread de busca de papeis
 * 
 * @since 2011-11
 */
public class BuscaPapeisThread extends Thread {

	private static final Logger log = Logger.getLogger( BuscaPapeisThread.class );
	
	@Override
	public void run() {
		
		log.debug( "thread [" + getName() + "] iniciada" );
		
		// TODO Auto-generated method stub
		super.run();
	}
	
}
