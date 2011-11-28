package br.com.otavio.easybroker.rest;

import static br.com.otavio.easybroker.rest.model.Papel.ABERTURA;
import static br.com.otavio.easybroker.rest.model.Papel.CODIGO;
import static br.com.otavio.easybroker.rest.model.Papel.DATA;
import static br.com.otavio.easybroker.rest.model.Papel.IBOVESPA;
import static br.com.otavio.easybroker.rest.model.Papel.MAXIMO;
import static br.com.otavio.easybroker.rest.model.Papel.MEDIO;
import static br.com.otavio.easybroker.rest.model.Papel.MINIMO;
import static br.com.otavio.easybroker.rest.model.Papel.NODE;
import static br.com.otavio.easybroker.rest.model.Papel.NOME;
import static br.com.otavio.easybroker.rest.model.Papel.OSCILACAO;
import static br.com.otavio.easybroker.rest.model.Papel.ULTIMO;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.com.otavio.easybroker.rest.model.Papel;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RestClient {

	private static final Logger log = Logger.getLogger(RestClient.class);

	/**
	 * Get a list of {@link Papel}
	 * 
	 * @param papeis
	 * @return
	 */
	public List< Papel > getPapeis( final String... papeis ) {

		log.debug("[getPapeis] papeis: " + papeis);

		if (ArrayUtils.isEmpty(papeis)) {
			return null;
		}

		Client client = new Client();

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("CodigoPapel", criaQueryPapeis(papeis));

		log.debug("[getPapeis] queryParams: " + queryParams);

		WebResource webResource = client
				.resource( "http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp" )
				.queryParams( queryParams );

		ClientResponse response = webResource
				.accept( "application/json" )
				.get( ClientResponse.class );

		log.debug("[getPapeis] response: " + response);

		if (response.getStatus() != 200) {
			throw new RuntimeException( "Failed: HTTP error code: " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		log.debug( "[getPapeis] output: " + output );
		
		List<Papel> papeisBeans = setElements(output);
		log.debug( "[getPapeis] papeisBeans size: " + papeisBeans.size() );
		
		return papeisBeans;
	}

	/**
	 * Parse xml string to java objects
	 * 
	 * @param output
	 * @return
	 */
	private List<Papel> setElements( final String output ) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		}
		catch (ParserConfigurationException e) {
			String msg = "Could not create a new DocumentoBuilder";
			log.error( msg );
			throw new RuntimeException( msg, e );
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(output));

		Document doc = null;
		try {
			doc = db.parse(is);
		}
		catch (SAXException e) {
			String msg = "Could not parse the InputSource to Document";
			log.error( msg );
			throw new RuntimeException( msg, e );
		}
		catch (IOException e) {
			String msg = "Could not parse the InputSource to Document";
			log.error( msg );
			throw new RuntimeException( msg, e );
		}
		
		NodeList nodes = doc.getElementsByTagName( NODE );
		
		List< Papel > papeisBeans = new ArrayList< Papel >();
		
		for (int i = 0; i < nodes.getLength(); i++) {

			Element element = (Element) nodes.item(i);
			
			Papel papel = new Papel();
			
			papel.setCodigo( element.getAttribute( CODIGO ));
			papel.setNome( element.getAttribute( NOME ));
			papel.setIbovespa( element.getAttribute( IBOVESPA ));
			papel.setData(  getDate( element.getAttribute( DATA )));
			papel.setAbertura( getFloat( element.getAttribute( ABERTURA )));
			papel.setMinimo( getFloat( element.getAttribute( MINIMO )));
			papel.setMaximo( getFloat( element.getAttribute( MAXIMO )));
			papel.setMedio( getFloat( element.getAttribute( MEDIO )));
			papel.setUltimo( getFloat( element.getAttribute( ULTIMO )));
			papel.setOscilacao( getFloat( element.getAttribute( OSCILACAO )));
			
			papeisBeans.add( papel );
		}
		
		return papeisBeans;
	}

	/**
	 * Get the float value from a string value
	 * 
	 * @param value
	 * @return
	 */
	private Float getFloat( final String value ) {
		
		return new Float( value.replaceAll(",", ".") );
	}
	
	/**
	 * Get the timestamp from a string date
	 * 
	 * @param string
	 * @return
	 */
	private Long getDate( final String string ) {

		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
		Date date = null;
		
		try {
			date = sdf.parse( string );
		} catch (ParseException e) {
			String msg = "Could parse the date string: " + string;
			log.error( msg );
			throw new RuntimeException( msg, e );
		}
		
		return date.getTime();
	}
	
	/**
	 * Cria string de consulta para o papeis
	 * 
	 * @param papeis
	 * @return
	 */
	private String criaQueryPapeis(final String... papeis) {

		StringBuilder builder = new StringBuilder();
		int i = 0;

		for (; i < (papeis.length - 1); i++) {
			builder.append(papeis[i]).append("|");
		}
		builder.append(papeis[i]);

		return builder.toString();
	}
	
	public static void main(String... args) {
		
		Float f1 = new Float("3,20".replaceAll(",", "."));
		System.out.println( "f1: " + f1 );
		Float f2 = new Float("3.15");
		System.out.println( "f2: " + f2 );
	}
	
}
