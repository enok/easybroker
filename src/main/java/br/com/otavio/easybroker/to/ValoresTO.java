/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.otavio.easybroker.to;

import java.util.Date;

/**
 *
 * @author Octavio Braga
 */
public class ValoresTO {
    private AcaoTO id_acao;
    private UsuarioTO usuario;
    private Date data_hr;
    private double valor_unitario;
    private int unidades;

public AcaoTO getAcao(){
    return id_acao;
}
public void setAcao(AcaoTO id_acao){
    this.id_acao = id_acao;
}

public Date getData(){
    return data_hr;
}
public void setData(Date data_hr){
    this.data_hr = data_hr;
}

public void setValorunit(double valor_unitario) {
	this.valor_unitario = valor_unitario;
}
public double getValorunit() {
	return valor_unitario;
}
public void setUnidades(int unidades) {
	this.unidades = unidades;
}
public int getUnidades() {
	return unidades;
}


public void setUsuario(UsuarioTO usuario) {
	this.usuario = usuario;
}
public UsuarioTO getUsuario() {
	return usuario;
}

}
