package br.com.otavio.easybroker.rest.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Papel {

	public static final String NODE = "Papel";

	public static final String CODIGO = "Codigo";
	public static final String NOME = "Nome";
	public static final String IBOVESPA = "Ibovespa";
	public static final String DATA = "Data";
	public static final String ABERTURA = "Abertura";
	public static final String MINIMO = "Minimo";
	public static final String MAXIMO = "Maximo";
	public static final String MEDIO = "Medio";
	public static final String ULTIMO = "Ultimo";
	public static final String OSCILACAO = "Oscilacao";

	private String codigo;

	private String nome;
	private String ibovespa;
	private Long data;
	private Float abertura;
	private Float minimo;
	private Float maximo;
	private Float medio;
	private Float ultimo;
	private Float oscilacao;

	public Papel() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIbovespa() {
		return ibovespa;
	}

	public void setIbovespa(String ibovespa) {
		this.ibovespa = ibovespa;
	}

	public Long getData() {
		return data;
	}

	public String getDataFormatada() {
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
		Date date = new Date( data );
		
		return sdf.format( date );
	}
	
	public void setData(Long data) {
		this.data = data;
	}

	public Float getAbertura() {
		return abertura;
	}

	public void setAbertura(Float abertura) {
		this.abertura = abertura;
	}

	public Float getMinimo() {
		return minimo;
	}

	public void setMinimo(Float minimo) {
		this.minimo = minimo;
	}

	public Float getMaximo() {
		return maximo;
	}

	public void setMaximo(Float maximo) {
		this.maximo = maximo;
	}

	public Float getMedio() {
		return medio;
	}

	public void setMedio(Float medio) {
		this.medio = medio;
	}

	public Float getUltimo() {
		return ultimo;
	}

	public void setUltimo(Float ultimo) {
		this.ultimo = ultimo;
	}

	public Float getOscilacao() {
		return oscilacao;
	}

	public void setOscilacao(Float oscilacao) {
		this.oscilacao = oscilacao;
	}

	public boolean isNegativo() {
		return oscilacao < 0;
	}
	
	@Override
	public String toString() {
		return codigo;
	}
}
