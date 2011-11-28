package br.com.otavio.easybroker.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.otavio.easybroker.rest.model.Papel;

public class RestClientTest {

	@Test
	public void getPapeisTest() {
		
		RestClient client = new RestClient();
		List<Papel> papeis = client.getPapeis( "PETR4", "VALE5" );
		assertNotNull( papeis );
		assertEquals( 2, papeis.size() );
		
	}
}
