package br.com.otavio.easybroker.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import br.com.otavio.easybroker.exception.ServiceException;
import br.com.otavio.easybroker.rest.model.Papel;

public class ConsultaPapeisThreadPoolService extends ScheduledThreadPoolExecutor {
	
	private static final Logger log = Logger.getLogger( ConsultaPapeisThreadPoolService.class );
	
	private long delay;
	private TimeUnit unit;
	private String papel;
	private Papel papelObj;
	private List< Papel > papeis;
	
	private RestClient restClient;
	
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
		
		restClient = new RestClient();
		
		addThread( new ConsultaPapeisThread( "consulta-papeis", this, restClient ) );
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

	public String getPapel() {
		return papel;
	}
	
	public void setPapel( String papel ) {
		this.papel = papel.toUpperCase();
	}
	
	/**
	 * @return the papelObj
	 */
	public Papel getPapelObj() {
		return papelObj;
	}

	/**
	 * @param papelObj the papelObj to set
	 */
	public void setPapelObj(Papel papelObj) {
		this.papelObj = papelObj;
	}

	/**
	 * Adicionar papel a tabela
	 */
	public void addPapel() {
		List< Papel > papelList = restClient.getPapeis( papel );
		
		if ( !CollectionUtils.isEmpty( papelList ) ) {
			this.papeis.addAll( papelList );
			Set< Papel > papelSet = new HashSet< Papel >();
			papelSet.addAll( papeis );
			this.papeis = new ArrayList<Papel>( papelSet );
		}
	}
	
	public void remPapel() {
		papeis.remove( papelObj );
	}
	
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
